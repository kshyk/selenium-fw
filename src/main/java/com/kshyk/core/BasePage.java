package com.kshyk.core;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;

import com.google.common.collect.Iterables;

public class BasePage {
	
	private final PageGenerator generator;
	private final Actions action;
	private final WebDriver driver;
	
	public BasePage(final WebDriver driver) {
		this.generator = new PageGenerator(driver);
		this.action = new Actions(driver);
		this.driver = driver;
	}
	
	public final <T> void click(final T elementAttr) {
		this.transformToWebElement(elementAttr).click();
	}
	
	public final <T> void writeText(final T elementAttr, final String text) {
		final WebElement element = this.transformToWebElement(elementAttr);
		element.clear();
		element.sendKeys(text);
	}
	
	public final void pressKey(final Keys key) {
		this.action.sendKeys(key).build().perform();
	}
	
	public final <T> String readText(final T elementAttr) {
		return this.transformToWebElement(elementAttr).getText();
	}
	
	public final <T> void mouseOver(final T elementAttr) {
		this.action.moveToElement(this.transformToWebElement(elementAttr)).build().perform();
	}
	
	public final <T> void mouseOverAndClick(final T elementAttr) {
		final WebElement target = this.transformToWebElement(elementAttr);
		this.action.moveToElement(target).click(target).build().perform();
	}
	
	public final void clickFirstVisibleElement(final By elementAttr) {
		final Stream<WebElement> stream = this.driver.findElements(elementAttr).stream();
		final Optional<WebElement> optionalElement = stream.filter(WebElement::isDisplayed).findFirst();
		optionalElement.ifPresent(WebElement::click);
	}
	
	public final void sleep(final int millis) {
		try {
			Thread.sleep(millis);
		}
		catch (final InterruptedException ex) {
			this.generator.getLogger().error("Unable to execute sleep thread.", ex);
		}
	}
	
	public final boolean isElementPresent(final By by) {
		return !this.driver.findElements(by).isEmpty();
	}
	
	public final boolean isElementDisplayed(final WebElement element) {
		try {
			return element.isDisplayed();
		}
		catch (final NoSuchElementException | ElementNotVisibleException ex) {
			return false;
		}
	}
	
	public final void switchToLastTab() {
		final Set<String> windowHandles = this.driver.getWindowHandles();
		this.driver.switchTo().window(Iterables.getLast(windowHandles));
	}
	
	private <T> WebElement transformToWebElement(final T elementAttr) {
		final boolean isItByElement = elementAttr.getClass().getName().contains("By");
		return isItByElement ? this.driver.findElement((By) elementAttr) : (WebElement) elementAttr;
	}
	
	public final Logger getLogger() {
		return this.generator.getLogger();
	}
}
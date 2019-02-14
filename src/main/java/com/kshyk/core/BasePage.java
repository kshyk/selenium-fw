package com.kshyk.core;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import com.google.common.collect.Iterables;

public class BasePage {
	
	private final PageGenerator generator;
	private final Actions action;
	private final WebDriver driver;
	private final WebDriverWait wait5sec, wait15sec, wait30sec;
	
	public BasePage(final WebDriver driver) {
		this.generator = new PageGenerator(driver);
		this.action = new Actions(driver);
		this.driver = driver;
		this.wait5sec = new WebDriverWait(driver, 5);
		this.wait15sec = new WebDriverWait(driver, 15);
		this.wait30sec = new WebDriverWait(driver, 30);
	}
	
	public final <T> void click(final T elementAttr) {
		final var element = this.transformToWebElement(elementAttr);
		this.wait5sec.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public final <T> void writeText(final T elementAttr, final String text) {
		final var element = this.transformToWebElement(elementAttr);
		element.clear();
		element.sendKeys(text);
	}
	
	public final void pressKey(final Keys key) {
		this.action.sendKeys(key).build().perform();
	}
	
	public final <T> String readText(final T elementAttr) {
		final var element = this.transformToWebElement(elementAttr);
		return this.wait5sec.until(ExpectedConditions.visibilityOf(element)).getText().trim();
	}
	
	public final <T> void mouseOver(final T elementAttr) {
		this.action.moveToElement(this.transformToWebElement(elementAttr)).build().perform();
	}
	
	public final <T> void mouseOverAndClick(final T elementAttr) {
		final var target = this.transformToWebElement(elementAttr);
		this.action.moveToElement(target).click(target).build().perform();
	}
	
	public final void clickFirstVisibleElement(final By elementAttr) {
		final var stream = this.driver.findElements(elementAttr).stream();
		final var optionalElement = stream.filter(WebElement::isDisplayed).findFirst();
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
		final var windowHandles = this.driver.getWindowHandles();
		this.driver.switchTo().window(Iterables.getLast(windowHandles));
	}
	
	private <T> WebElement transformToWebElement(final T elementAttr) {
		final var isItByElement = elementAttr.getClass().getName().contains("By");
		return isItByElement ? this.driver.findElement((By) elementAttr) : (WebElement) elementAttr;
	}
	
	public final Logger getLogger() {
		return this.generator.getLogger();
	}
}
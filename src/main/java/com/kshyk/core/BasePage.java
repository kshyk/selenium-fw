package com.kshyk.core;

import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;

public class BasePage extends PageGenerator {
	
	protected BasePage(final WebDriver driver) {
		super(driver);
	}
	
	protected <T> void click(final T elementAttr) {
		final boolean isItByElement = elementAttr.getClass().getName().contains("By");
		(isItByElement ? this.getDriver().findElement((By) elementAttr) : ((WebElement) elementAttr)).click();
	}
	
	protected <T> void writeText(final T elementAttr, final String text) {
		final boolean isItByElement = elementAttr.getClass().getName().contains("By");
		(isItByElement ? this.getDriver().findElement((By) elementAttr) : ((WebElement) elementAttr)).sendKeys(text);
	}
	
	protected void pressKey(final Keys key) {
		this.getKeyboard().pressKey(key);
	}
	
	protected <T> String readText(final T elementAttr) {
		final boolean isItByElement = elementAttr.getClass().getName().contains("By");
		return (isItByElement ? this.getDriver().findElement((By) elementAttr) : ((WebElement) elementAttr)).getText();
	}
	
	protected <T> void mouseOver(final T elementAttr) {
		final Locatable locatable = this.getLocatable(elementAttr);
		this.getMouse().mouseMove(locatable.getCoordinates());
	}
	
	protected <T> void mouseOverAndClick(final T elementAttr) {
		final Locatable locatable = this.getLocatable(elementAttr);
		this.getMouse().mouseMove(locatable.getCoordinates());
		this.getMouse().click(locatable.getCoordinates());
	}
	
	protected void clickFirstVisibleElement(final By elementAttr) {
		final Stream<WebElement> stream = this.getDriver().findElements(elementAttr).stream();
		final Optional<WebElement> optionalElement = stream.filter(WebElement::isDisplayed).findFirst();
		optionalElement.ifPresent(WebElement::click);
	}
	
	private <T> Locatable getLocatable(final T elementAttr) {
		return elementAttr.getClass().getName().contains("By") ?
				((Locatable) this.getDriver().findElement((By) elementAttr)) : ((Locatable) elementAttr);
	}
	
	private Mouse getMouse() {
		return ((HasInputDevices) this.getDriver()).getMouse();
	}
	
	private Keyboard getKeyboard() {
		return ((HasInputDevices) this.getDriver()).getKeyboard();
	}
	
	public void sleep(final int millis) {
		try {
			Thread.sleep(millis);
		}
		catch (final InterruptedException ex) {
			this.getLogger().error("Unable to execute sleep thread.", ex);
		}
	}
	
	protected boolean isElementPresent(final By by) {
		return !this.getDriver().findElements(by).isEmpty();
	}
	
	public void switchToLastTab() {
		final Stream<String> stream = this.getDriver().getWindowHandles().stream();
		final Optional<String> optional = stream.reduce((first, second) -> second);
		optional.ifPresent(tab -> this.getDriver().switchTo().window(tab));
	}
}
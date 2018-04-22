package com.kshyk.core;

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
        (isItByElement ? driver.findElement((By) elementAttr) : ((WebElement) elementAttr)).click();
    }

    protected <T> void writeText(final T elementAttr, final String text) {
        final boolean isItByElement = elementAttr.getClass().getName().contains("By");
        (isItByElement ? driver.findElement((By) elementAttr) : ((WebElement) elementAttr)).sendKeys(text);
    }

    protected void pressKey(final Keys key) {
        this.getKeyboard().pressKey(key);
    }

    protected <T> String readText(final T elementAttr) {
        final boolean isItByElement = elementAttr.getClass().getName().contains("By");
        return (isItByElement ? driver.findElement((By) elementAttr) : ((WebElement) elementAttr)).getText();
    }

    protected <T> void mouseOver(final T elementAttr) {
        Locatable locatable = this.getLocatable(elementAttr);
        this.getMouse().mouseMove(locatable.getCoordinates());
    }

    protected <T> void mouseOverAndClick(final T elementAttr) {
        Locatable locatable = this.getLocatable(elementAttr);
        this.getMouse().mouseMove(locatable.getCoordinates());
        this.getMouse().click(locatable.getCoordinates());
    }

    protected void clickFirstVisibleElement(final By elementAttr) {
        driver.findElements(elementAttr).forEach(element -> {
            if (element.isDisplayed()) {
                click(element);
            }
        });
    }

    private <T> Locatable getLocatable(final T elementAttr) {
        return elementAttr.getClass().getName().contains("By") ?
                ((Locatable) driver.findElement((By) elementAttr)) : ((Locatable) elementAttr);
    }

    private Mouse getMouse() {
        return ((HasInputDevices) driver).getMouse();
    }

    private Keyboard getKeyboard() {
        return ((HasInputDevices) driver).getKeyboard();
    }

    public void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException ex) {
            logger.error("Unable to execute sleep thread.", ex);
        }
    }

    protected boolean isElementPresent(final By by) {
        return driver.findElements(by).size() != 0;
    }
}
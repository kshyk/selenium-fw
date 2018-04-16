package com.kshyk.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;

import java.util.List;

public class BasePage extends PageGenerator {

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    protected <T> void click(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    protected <T> void writeText(T elementAttr, String text) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    protected <T> String readText(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    public void handlePopup(By by) throws InterruptedException {
        List<WebElement> popup = driver.findElements(by);
        if (!popup.isEmpty()) {
            popup.get(0).click();
            Thread.sleep(200);
        }
    }

    protected <T> void mouseOver(T elementAttr) {
        Locatable locatable = this.getLocatable(elementAttr);
        this.getMouse().mouseMove(locatable.getCoordinates());
    }

    protected <T> void mouseOverAndClick(T elementAttr) {
        Locatable locatable = this.getLocatable(elementAttr);
        this.getMouse().mouseMove(locatable.getCoordinates());
        this.getMouse().click(locatable.getCoordinates());
    }

    private <T> Locatable getLocatable(T elementAttr) {
        return elementAttr.getClass().getName().contains("By") ?
                ((Locatable) driver.findElement((By) elementAttr)) : ((Locatable) elementAttr);
    }

    private Mouse getMouse() {
        return ((HasInputDevices) driver).getMouse();
    }

}
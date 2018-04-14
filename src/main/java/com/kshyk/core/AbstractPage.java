package com.kshyk.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected void click(final By by) {
        Locatable element = this.getLocatable(by);
        Mouse mouse = this.getMouse();
        mouse.mouseMove(element.getCoordinates());
        mouse.click(element.getCoordinates());
    }

    protected void doubleClick(final By by) {
        Locatable element = this.getLocatable(by);
        Mouse mouse = this.getMouse();
        mouse.mouseMove(element.getCoordinates());
        mouse.doubleClick(element.getCoordinates());
    }

    protected void contextClick(final By by) {
        Locatable element = this.getLocatable(by);
        Mouse mouse = this.getMouse();
        mouse.mouseMove(element.getCoordinates());
        mouse.contextClick(element.getCoordinates());
    }

    private Locatable getLocatable(final By by) {
        return (Locatable) driver.findElement(by);
    }

    private Mouse getMouse() {
        return ((HasInputDevices) driver).getMouse();
    }

    private Keyboard getKeyboard() {
        return ((HasInputDevices) driver).getKeyboard();
    }

}

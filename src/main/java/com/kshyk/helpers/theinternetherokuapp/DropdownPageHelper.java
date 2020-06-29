package com.kshyk.helpers.theinternetherokuapp;

import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class DropdownPageHelper {
    private DropdownPageHelper() {
    }

    public static void selectByValue(String value) {
        new Select($(id("dropdown"))).selectByValue(value);
    }

    public static void selectByIndex(int index) {
        new Select($(id("dropdown"))).selectByIndex(index);
    }

    public static void selectByVisibleText(String text) {
        new Select($(id("dropdown"))).selectByVisibleText(text);
    }

    public static String getSelectedText() {
        return $(id("dropdown")).text().trim();
    }
}
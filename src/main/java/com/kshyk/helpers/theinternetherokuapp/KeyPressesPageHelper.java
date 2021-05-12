package com.kshyk.helpers.theinternetherokuapp;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class KeyPressesPageHelper {
    private KeyPressesPageHelper() {
    }

    public static void pressKey(Keys key) {
        $("body").sendKeys(key);
    }

    public static String getResultText() {
        return $("#result").text();
    }
}

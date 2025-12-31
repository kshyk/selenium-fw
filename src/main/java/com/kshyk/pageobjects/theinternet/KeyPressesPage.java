package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class KeyPressesPage {
    public static KeyPressesPage open() {
        return Selenide.open("/key_presses", KeyPressesPage.class);
    }

    public KeyPressesPage pressKey(Keys key) {
        $("body").sendKeys(key);
        return this;
    }

    public String getResultText() {
        return $("#result").text();
    }
}

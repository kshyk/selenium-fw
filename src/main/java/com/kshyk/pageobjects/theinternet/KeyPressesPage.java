package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class KeyPressesPage {
    public static KeyPressesPage open() {
        Selenide.open("/key_presses");
        return new KeyPressesPage();
    }

    public KeyPressesPage pressKey(Keys key) {
        $("body").sendKeys(key);
        return this;
    }

    public String getResultText() {
        return $("#result").text();
    }
}

package com.kshyk.pageobjects.theinternetherokuapp;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class BasicAuthPage {
    public BasicAuthPage titleShouldHaveText(String text) {
        $(tagName("h3")).shouldHave(text(text));
        return this;
    }

    public void pageShouldHaveText(String text) {
        $(id("content")).shouldHave(text(text));
    }
}
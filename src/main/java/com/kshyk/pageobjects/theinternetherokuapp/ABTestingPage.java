package com.kshyk.pageobjects.theinternetherokuapp;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;

public class ABTestingPage {
    public void titleShouldHaveText(String text) {
        $(tagName("h3")).shouldHave(text(text));
    }
}
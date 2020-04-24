package com.kshyk.pageobjects.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;

public class ABTestingPage {
    public String getTitleText() {
        return $(tagName("h3")).getText();
    }
}
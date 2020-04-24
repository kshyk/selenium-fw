package com.kshyk.pageobjects.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public class DigestAuthPage {
    public String getTitleText() {
        return $(tagName("h3")).getText();
    }

    public String getContentText() {
        return $(id("content")).getText();
    }
}
package com.kshyk.interfaces;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public interface PageContent {
    static String getTitleText() {
        return $(tagName("h3")).text().trim();
    }

    static String getContentText() {
        return $(id("content")).text().trim();
    }
}
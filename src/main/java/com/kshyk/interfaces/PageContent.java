package com.kshyk.interfaces;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

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

    static List<SelenideElement> getLinks() {
        return $(id("content")).$$(tagName("a"));
    }
}
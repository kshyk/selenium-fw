package com.kshyk.interfaces;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public interface PageContent {
    static String getTitleText() {
        return getText(tagName("h3"));
    }

    static String getContentText() {
        return getText(id("content"));
    }

    static List<SelenideElement> getLinks() {
        return $(id("content")).$$(tagName("a"));
    }

    static String getBodyText() {
        return getText(tagName("body"));
    }

    private static String getText(By by) {
        return $(by).text().trim();
    }
}
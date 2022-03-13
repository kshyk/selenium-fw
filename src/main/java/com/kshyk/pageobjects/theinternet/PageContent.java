package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.tagName;

public interface PageContent {
    default List<SelenideElement> getLinks() {
        return $("#content").$$("a");
    }

    default String getText(By by) {
        return $(by).text().trim();
    }

    default String getBodyText() {
        return getText(tagName("body"));
    }

    default String getTitleText() {
        return getText(tagName("h3"));
    }

    default String getContentText() {
        return getText(id("content"));
    }
}

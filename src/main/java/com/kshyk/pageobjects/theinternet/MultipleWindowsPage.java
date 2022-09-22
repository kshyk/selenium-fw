package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MultipleWindowsPage implements PageContent {
    public static MultipleWindowsPage open() {
        Selenide.open("/windows");
        return new MultipleWindowsPage();
    }

    public void openNewWindow() {
        $(byLinkText("Click Here")).hover().click();
        switchTo().window("New Window");
    }

    public void closeNewWindow() {
        getWebDriver().close();
        switchTo().window(0);
    }
}

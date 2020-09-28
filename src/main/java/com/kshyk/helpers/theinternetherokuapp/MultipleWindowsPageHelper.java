package com.kshyk.helpers.theinternetherokuapp;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MultipleWindowsPageHelper {
    private MultipleWindowsPageHelper() {
    }

    public static void openNewWindow() {
        $(byLinkText("Click Here")).click();
        switchTo().window(1);
    }

    public static void closeNewWindow() {
        getWebDriver().close();
        switchTo().window(0);
    }
}

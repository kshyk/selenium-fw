package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class JavaScriptAlertsPage implements PageContent {
    public static JavaScriptAlertsPage open() {
        return Selenide.open("/javascript_alerts", JavaScriptAlertsPage.class);
    }

    public void clickOnJsAlertButton() {
        $("[onclick='jsAlert()']").click();
    }

    public void clickOnJsConfirmButton() {
        $("[onclick='jsConfirm()']").click();
    }

    public void clickOnJsPromptButton() {
        $("[onclick='jsPrompt()']").click();
    }
}

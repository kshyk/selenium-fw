package com.kshyk.pageobjects.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$;

public class JavaScriptAlertsPage {
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
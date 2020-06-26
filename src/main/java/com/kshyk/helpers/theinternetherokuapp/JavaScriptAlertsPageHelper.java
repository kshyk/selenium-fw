package com.kshyk.helpers.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$;

public class JavaScriptAlertsPageHelper {
    private JavaScriptAlertsPageHelper() {
    }

    public static void clickOnJsAlertButton() {
        $("[onclick='jsAlert()']").click();
    }

    public static void clickOnJsConfirmButton() {
        $("[onclick='jsConfirm()']").click();
    }

    public static void clickOnJsPromptButton() {
        $("[onclick='jsPrompt()']").click();
    }
}
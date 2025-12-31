package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.JavaScriptAlertsPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

class JavaScriptAlertsPageTests extends TheInternetTestCase {
    private JavaScriptAlertsPage page;

    @BeforeAll
    void openJavascriptAlertsPage() {
        page = JavaScriptAlertsPage.open();
    }

    @Test
    void simpleAlertShouldAppear() {
        page.clickOnJsAlertButton();
        confirm();
        assertThat(page.getContentText())
            .as("Simple alert didn't appear")
            .contains("You successfully clicked an alert");
    }

    @Test
    void dismissShouldCancelAlert() {
        page.clickOnJsConfirmButton();
        dismiss();
        assertThat(page.getContentText())
            .as("Dismiss didn't cancel alert")
            .contains("You clicked: Cancel");
    }

    @Test
    void promptShouldSaveAlertText() {
        page.clickOnJsPromptButton();
        var value = "I'm typing in here!";
        prompt(value);
        assertThat(page.getContentText())
            .as("Prompt didn't save '%s' text", value)
            .contains("You entered: " + value);
    }
}

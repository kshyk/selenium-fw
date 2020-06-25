package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.pageobjects.theinternetherokuapp.JavaScriptAlertsPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaScriptAlertsPageTests extends TestCase {
    private JavaScriptAlertsPage page;

    @BeforeAll
    public void openJavascriptAlertsPage() {
        page = open("http://the-internet.herokuapp.com/javascript_alerts", JavaScriptAlertsPage.class);
    }

    @Test
    public void isSimpleAlertAppeared() {
        page.clickOnJsAlertButton();
        confirm();
        assertTrue($(byText("You successfuly clicked an alert")).isDisplayed());
    }

    @Test
    public void isConfirmAlertCancelled() {
        page.clickOnJsConfirmButton();
        dismiss();
        assertTrue($(byText("You clicked: Cancel")).isDisplayed());
    }

    @Test
    public void isPromptAlertSaveText() {
        page.clickOnJsPromptButton();
        var value = "I'm typing in here!";
        prompt(value);
        assertTrue($(byText("You entered: " + value)).isDisplayed());
    }
}
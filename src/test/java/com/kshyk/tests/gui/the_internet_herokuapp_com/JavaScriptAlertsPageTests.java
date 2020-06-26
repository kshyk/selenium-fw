package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.JavaScriptAlertsPageHelper;
import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.confirm;
import static com.codeborne.selenide.Selenide.dismiss;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.prompt;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaScriptAlertsPageTests extends TestCase {
    @BeforeAll
    public void openJavascriptAlertsPage() {
        open("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void isSimpleAlertAppeared() {
        JavaScriptAlertsPageHelper.clickOnJsAlertButton();
        confirm();
        assertTrue(PageContent.getContentText().contains("You successfuly clicked an alert"));
    }

    @Test
    public void isConfirmAlertCancelled() {
        JavaScriptAlertsPageHelper.clickOnJsConfirmButton();
        dismiss();
        assertTrue(PageContent.getContentText().contains("You clicked: Cancel"));
    }

    @Test
    public void isPromptAlertSaveText() {
        JavaScriptAlertsPageHelper.clickOnJsPromptButton();
        var value = "I'm typing in here!";
        prompt(value);
        assertTrue(PageContent.getContentText().contains("You entered: " + value));
    }
}
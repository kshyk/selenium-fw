package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JavaScriptAlertsPageTests extends TestCase {
    @Test
    public final void isJavaScriptAlertsPageLoaded() {
        open("http://the-internet.herokuapp.com/javascript_alerts");
        $(byText("JavaScript Alerts")).should(appear);
    }

    @Test(dependsOnMethods = "isJavaScriptAlertsPageLoaded")
    public final void isSimpleAlertAppeared() {
        $("[onclick='jsAlert()']").click();
        confirm();
        $(byText("You successfuly clicked an alert")).should(appear);
    }

    @Test(dependsOnMethods = "isSimpleAlertAppeared")
    public final void isConfirmAlertCancelled() {
        $("[onclick='jsConfirm()']").click();
        dismiss();
        $(byText("You clicked: Cancel")).should(appear);
    }

    @Test(dependsOnMethods = "isConfirmAlertCancelled")
    public final void isPromptAlertSaveText() {
        $("[onclick='jsPrompt()']").click();
        final var value = "I'm typing in here!";
        prompt(value);
        final var expected = "You entered: " + value;
        $(byText(expected)).should(appear);
    }
}
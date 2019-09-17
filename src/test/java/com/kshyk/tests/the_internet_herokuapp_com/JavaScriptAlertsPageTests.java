package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class JavaScriptAlertsPageTests extends TestCase {
    @BeforeAll
    void openJavascriptAlertsPage() {
        open("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void isSimpleAlertAppeared() {
        $("[onclick='jsAlert()']").click();
        confirm();
        $(byText("You successfuly clicked an alert")).should(appear);
    }

    @Test
    void isConfirmAlertCancelled() {
        $("[onclick='jsConfirm()']").click();
        dismiss();
        $(byText("You clicked: Cancel")).should(appear);
    }

    @Test
    void isPromptAlertSaveText() {
        $("[onclick='jsPrompt()']").click();
        var value = "I'm typing in here!";
        prompt(value);
        var expected = "You entered: " + value;
        $(byText(expected)).should(appear);
    }
}
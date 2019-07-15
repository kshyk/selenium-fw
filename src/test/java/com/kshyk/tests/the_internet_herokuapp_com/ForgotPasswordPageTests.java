package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ForgotPasswordPageTests extends TestCase {
    @Test(groups = "open forgot password")
    public final void isForgotPasswordPageLoaded() {
        open("http://the-internet.herokuapp.com/forgot_password");
        $(byText("Forgot Password")).should(appear);
    }

    @Test(dependsOnGroups = "open forgot password")
    public final void isPasswordReset() {
        $("#email").val("test@example.com");
        $("#form_submit").submit();
        $(byText("Your e-mail's been sent!")).should(appear);
    }
}
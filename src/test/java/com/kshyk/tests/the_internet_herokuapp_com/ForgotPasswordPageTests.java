package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class ForgotPasswordPageTests extends TestCase {
    @Test
    void passwordShouldReset() {
        open("http://the-internet.herokuapp.com/forgot_password");
        $("#email").val("test@example.com");
        $("#form_submit").submit();
        $(byText("Your e-mail's been sent!")).should(appear);
    }
}
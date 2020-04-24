package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.pageobjects.theinternetherokuapp.ForgotPasswordPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForgotPasswordPageTests extends TestCase {
    @Test
    public void passwordShouldReset() {
        var page = open("http://the-internet.herokuapp.com/forgot_password", ForgotPasswordPage.class);
        page.retrievePassword("test@example.com");
        assertTrue($(byText("Your e-mail's been sent!")).isDisplayed());
    }
}
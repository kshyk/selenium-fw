package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.ForgotPasswordPageHelper;
import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ForgotPasswordPageTests extends TestCase {
    @BeforeAll
    public void openForgotPasswordPage() {
        open("http://the-internet.herokuapp.com/forgot_password");
    }

    @Test
    public void passwordShouldReset() {
        ForgotPasswordPageHelper.retrievePassword("test@example.com");
        assertEquals("Your e-mail's been sent!", PageContent.getContentText());
    }
}
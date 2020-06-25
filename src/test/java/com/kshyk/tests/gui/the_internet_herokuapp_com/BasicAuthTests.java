package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.codeborne.selenide.Credentials;
import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.AuthenticationType.BASIC;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAuthTests extends TestCase {
    @BeforeAll
    public void setupBasicAuthentication() {
        var credentials = new Credentials("admin", "admin");
        open("http://the-internet.herokuapp.com/basic_auth", BASIC, credentials);
    }

    @Test
    public void titleShouldBeBasicAuth() {
        assertEquals("Basic Auth", PageContent.getTitleText());
    }

    @Test
    public void congratsShouldAppearIfSuccessfullyAuthenticated() {
        assertTrue(PageContent.getContentText().contains("Congratulations!"));
    }
}
package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DigestAuthTests extends TestCase {
    @BeforeAll
    void setupDigestAuthentication() {
        open("http://admin:admin@the-internet.herokuapp.com/digest_auth");
    }

    @Test
    void titleShouldBeDigestAuth() {
        assertEquals("Digest Auth", PageContent.getTitleText());
    }

    @Test
    void congratsShouldAppearIfSuccessfullyAuthenticated() {
        assertTrue(PageContent.getContentText().contains("Congratulations!"));
    }
}

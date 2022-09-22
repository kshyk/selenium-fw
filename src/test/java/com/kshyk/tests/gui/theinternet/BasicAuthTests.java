package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.BasicAuthPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BasicAuthTests extends TheInternetTestCase {
    private BasicAuthPage page;

    @BeforeAll
    void setupBasicAuthentication() {
        page = BasicAuthPage.open();
    }

    @Test
    void congratsShouldAppearIfSuccessfullyAuthenticated() {
        softly.then(page.getTitleText())
            .as("Page title didn't match").isEqualTo("Basic Auth");
        softly.then(page.getContentText())
            .as("Page is not authenticated").contains("Congratulations!");
    }
}

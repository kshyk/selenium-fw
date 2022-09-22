package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.DigestAuthPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DigestAuthTests extends TheInternetTestCase {
    private DigestAuthPage page;

    @BeforeAll
    void setupDigestAuthentication() {
        page = DigestAuthPage.open();
    }

    @Test
    void congratsShouldAppearIfSuccessfullyAuthenticated() {
        softly.then(page.getTitleText())
            .as("Page title didn't match").isEqualTo("Digest Auth");
        softly.then(page.getContentText())
            .as("Page is not authenticated").contains("Congratulations!");
    }
}

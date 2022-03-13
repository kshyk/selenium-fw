package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.DigestAuthPage;
import org.assertj.core.api.SoftAssertions;
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
        var assertions = new SoftAssertions();
        assertions.assertThat(page.getTitleText())
            .as("Page title didn't match").isEqualTo("Digest Auth");
        assertions.assertThat(page.getContentText())
            .as("Page is not authenticated").contains("Congratulations!");
        assertions.assertAll();
    }
}

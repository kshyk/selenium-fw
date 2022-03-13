package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.BasicAuthPage;
import org.assertj.core.api.SoftAssertions;
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
        var assertions = new SoftAssertions();
        assertions.assertThat(page.getTitleText())
            .as("Page title didn't match").isEqualTo("Basic Auth");
        assertions.assertThat(page.getContentText())
            .as("Page is not authenticated").contains("Congratulations!");
        assertions.assertAll();
    }
}

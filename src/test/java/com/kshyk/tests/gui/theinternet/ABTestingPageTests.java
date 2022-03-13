package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.ABTestingPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ABTestingPageTests extends TheInternetTestCase {
    private ABTestingPage page;

    @BeforeAll
    void openABTestPage() {
        page = ABTestingPage.open();
    }

    @Test
    void isABTestPageLoaded() {
        assertThat(page.getTitleText()).as("A/B testing page didn't open").contains("A/B Test");
    }
}

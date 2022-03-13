package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.MultipleWindowsPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MultipleWindowsPageTests extends TheInternetTestCase {
    private MultipleWindowsPage page;

    @BeforeAll
    void openMultipleWindowsPage() {
        page = MultipleWindowsPage.open();
    }

    @Test
    void checkOpenAndCloseActionsOnNewWindow() {
        page.openNewWindow();
        var assertions = new SoftAssertions();
        assertions.assertThat(page.getTitleText())
            .as("Unable switch to new window").isEqualTo("New Window");
        page.closeNewWindow();
        assertions.assertThat(page.getTitleText())
            .as("Unable switch back to entry page").isEqualTo("Opening a new window");
        assertions.assertAll();
    }
}

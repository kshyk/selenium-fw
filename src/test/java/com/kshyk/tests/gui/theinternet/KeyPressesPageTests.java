package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.KeyPressesPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;

class KeyPressesPageTests extends TheInternetTestCase {
    private KeyPressesPage page;

    @BeforeAll
    void openKeyPressesPage() {
        page = KeyPressesPage.open();
    }

    @Test
    void isKeyProperlyEntered() {
        var tab = Keys.TAB;
        page.pressKey(tab);
        assertThat(page.pressKey(tab).getResultText())
            .as("Pressing keys are not supported")
            .isEqualTo("You entered: " + tab.name());
    }
}

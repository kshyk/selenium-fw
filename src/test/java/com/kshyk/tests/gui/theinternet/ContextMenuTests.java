package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.ContextMenuPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.switchTo;
import static org.assertj.core.api.Assertions.assertThat;

class ContextMenuTests extends TheInternetTestCase {
    private ContextMenuPage page;
    private Alert alert;

    @BeforeAll
    void openContextMenuPage() {
        page = ContextMenuPage.open();
    }

    @Test
    void contextClickShouldTriggerAlert() {
        page.contextClickOnHotSpot();
        alert = switchTo().alert();
        assertThat(alert.getText()).as("Context click is disabled for hot-spot")
            .isEqualTo("You selected a context menu");
    }

    @AfterAll
    void closeAlertPrompt() {
        Optional.ofNullable(alert).ifPresent(Alert::accept);
    }
}

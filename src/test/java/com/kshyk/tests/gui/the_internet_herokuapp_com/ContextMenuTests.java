package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.ContextMenuPageHelper;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContextMenuTests extends TestCase {
    private Alert alert;

    @BeforeAll
    void openContextMenuPage() {
        open("http://the-internet.herokuapp.com/context_menu");
    }

    @Test
    void contextClickShouldTriggerAlert() {
        ContextMenuPageHelper.contextClickOnHotSpot();
        alert = switchTo().alert();
        assertEquals("You selected a context menu", alert.getText());
    }

    @AfterAll
    void closeAlertPrompt() {
        if (alert != null)
            alert.accept();
    }
}

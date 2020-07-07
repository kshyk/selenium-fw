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

public class ContextMenuTests extends TestCase {
    private Alert alert;

    @BeforeAll
    public void openContextMenuPage() {
        open("http://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void contextClickShouldTriggerAlert() {
        ContextMenuPageHelper.contextClickOnHotSpot();
        alert = switchTo().alert();
        assertEquals("You selected a context menu", alert.getText());
    }

    @AfterAll
    public void closeAlertPrompt() {
        if (alert != null)
            alert.accept();
    }
}
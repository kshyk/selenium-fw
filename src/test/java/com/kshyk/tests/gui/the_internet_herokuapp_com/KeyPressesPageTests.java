package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.KeyPressesPageHelper;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KeyPressesPageTests extends TestCase {
    @BeforeAll
    public void openKeyPressesPage() {
        open("http://the-internet.herokuapp.com/key_presses");
    }

    @Test
    public void isKeyProperlyEntered() {
        var tab = Keys.TAB;
        KeyPressesPageHelper.pressKey(tab);
        assertEquals("You entered: " + tab.name(), KeyPressesPageHelper.getResultText());
    }
}
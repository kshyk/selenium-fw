package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.KeyPressesPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KeyPressesPageTests extends BaseTest {

    @Test
    public void checkPage_IsKeyPressesPageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        page.getInstance(HomePage.class).goToKeyPresses();
        assertTrue(page.getInstance(KeyPressesPage.class).isOpen(),
                KeyPressesPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "checkPage_IsKeyPressesPageLoaded")
    public void checkPage_IsKeyProperlyEntered() {
        final Keys control = Keys.CONTROL;
        final String expected = "You entered: " + control.name();
        final String actual = page.getInstance(KeyPressesPage.class).pressKeyAndGetResult(control);
        assertEquals(actual, expected);
    }

}
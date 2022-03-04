package com.kshyk.tests.gui.pajacyk_pl;

import com.kshyk.pageobjects.pajacyk.HomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PuppetDonateTests extends TestCase {
    private HomePage homePage;

    @BeforeAll
    void preconditions() {
        homePage = HomePage.open();
    }

    @Test
    void clickOnPuppetBellyShouldDonate() {
        homePage.donate();
        var message = "Clicking on the belly does not donate";
        assertTrue(homePage.isDonated(), message);
    }
}

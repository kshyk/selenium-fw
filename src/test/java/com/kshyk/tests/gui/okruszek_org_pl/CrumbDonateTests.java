package com.kshyk.tests.gui.okruszek_org_pl;

import com.kshyk.pageobjects.okruszek.HomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CrumbDonateTests extends TestCase {
    private HomePage homePage;

    @BeforeAll
    void preconditions() {
        homePage = HomePage.open();
    }

    @Test
    void clickOnBreadShouldDonate() {
        homePage.donate();
        var message = "Clicking on the breadcrumb does not donate";
        assertTrue(homePage.isDonated(), message);
    }
}

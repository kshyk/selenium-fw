package com.kshyk.tests.gui.okruszek_org_pl;

import com.kshyk.helpers.okruszek.HomePageHelper;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CrumbClickTests extends TestCase {
    @BeforeAll
    public void openHomePage() {
        open("http://www.okruszek.org.pl/");
    }

    @Test
    public void clickShouldGiveBreadcrumb() {
        HomePageHelper.clickOnBread();
        assertTrue(HomePageHelper.isThanksDisplayed());
    }
}
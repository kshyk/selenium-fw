package com.kshyk.tests.gui.pajacyk_pl;

import com.kshyk.helpers.pajacyk.HomePageHelper;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BellyClickTests extends TestCase {
    @BeforeAll
    public void openHomePage() {
        open("https://www.pajacyk.pl/#index");
    }

    @Test
    public void puppetShouldBeHappy() {
        HomePageHelper.clickOnBelly();
        assertTrue(HomePageHelper.isThanksDisplayed());
    }
}
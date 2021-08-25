package com.kshyk.tests.gui.pajacyk_pl;

import com.kshyk.helpers.pajacyk.HomePageHelper;
import com.kshyk.tests.base.TestCase;
import io.github.artsok.RepeatedIfExceptionsTest;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BellyClickTests extends TestCase {
    @BeforeAll
    public void openHomePage() {
        open("https://www.pajacyk.pl/#index");
    }

    @RepeatedIfExceptionsTest
    public void puppetShouldBeHappy() {
        HomePageHelper.clickOnBelly();
        assertTrue(HomePageHelper.isThanksDisplayed());
    }
}
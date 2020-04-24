package com.kshyk.tests.pajacyk_pl;

import com.kshyk.pageobjects.pajacyk.PajacykHomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BellyClickTests extends TestCase {
    @Test
    public void puppetShouldBeHappy() {
        var homePage = open("https://www.pajacyk.pl/#index", PajacykHomePage.class);
        assertTrue(homePage.clickOnBelly().isThanksDisplayed());
    }
}
package com.kshyk.tests.pajacyk_pl;

import com.kshyk.pageobjects.pajacyk.PajacykHomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BellyClickTests extends TestCase {
    @Test
    public void puppetShouldBeHappy() {
        var pajacykUrl = "https://www.pajacyk.pl/#index";
        var homePage = open(pajacykUrl, PajacykHomePage.class);
        var thanks = homePage.clickOnBelly().thanks();
        assertTrue(thanks.should(appear).isDisplayed());
    }
}
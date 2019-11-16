package com.kshyk.tests.pajacyk_pl;

import com.kshyk.po.pajacyk.PajacykHomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.open;

class BellyClickTests extends TestCase {
    @Test
    void puppetShouldBeHappy() {
        var pajacykUrl = "https://www.pajacyk.pl/#index";
        var homePage = open(pajacykUrl, PajacykHomePage.class);
        var thanksPage = homePage.clickOnBelly();
        thanksPage.thanks().should(appear);
    }
}
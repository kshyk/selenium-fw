package com.kshyk.tests.okruszek_org_pl;

import com.kshyk.pageobjects.okruszek.OkruszekHomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CrumbClickTests extends TestCase {
    @Test
    public void clickShouldGiveBreadcrumb() {
        var okruszekUrl = "http://www.okruszek.org.pl/";
        var homePage = open(okruszekUrl, OkruszekHomePage.class);
        var thanks = homePage.clickOnBread().thanks();
        assertTrue(thanks.should(appear).isDisplayed());
    }
}
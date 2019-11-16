package com.kshyk.tests.okruszek_org_pl;

import com.kshyk.po.okruszek.OkruszekHomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.open;

class CrumbClickTests extends TestCase {
    @Test
    void clickShouldGiveBreadcrumb() {
        var okruszekUrl = "http://www.okruszek.org.pl/";
        var homePage = open(okruszekUrl, OkruszekHomePage.class);
        homePage.clickOnBread().thanks().should(appear);
    }
}
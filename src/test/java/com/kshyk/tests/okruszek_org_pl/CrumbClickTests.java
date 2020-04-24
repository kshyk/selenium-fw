package com.kshyk.tests.okruszek_org_pl;

import com.kshyk.pageobjects.okruszek.OkruszekHomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.BDDAssertions.then;

class CrumbClickTests extends TestCase {
    @Test
    public void clickShouldGiveBreadcrumb() {
        var homePage = open("http://www.okruszek.org.pl/", OkruszekHomePage.class);
        then(homePage.clickOnBread().isThanksDisplayed()).isTrue();
    }
}
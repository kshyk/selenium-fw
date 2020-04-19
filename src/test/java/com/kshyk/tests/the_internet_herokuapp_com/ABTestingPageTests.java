package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.pageobjects.theinternetherokuapp.ABTestingPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

class ABTestingPageTests extends TestCase {
    @Test
    public void isABTestPageLoaded() {
        var url = "http://the-internet.herokuapp.com/abtest";
        var page = open(url, ABTestingPage.class);
        page.titleShouldHaveText("A/B Test");
    }
}
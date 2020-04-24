package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.pageobjects.theinternetherokuapp.ABTestingPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ABTestingPageTests extends TestCase {
    @Test
    public void isABTestPageLoaded() {
        var page = open("http://the-internet.herokuapp.com/abtest", ABTestingPage.class);
        assertEquals("A/B Test", page.getTitleText());
    }
}
package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomePageTests extends TestCase {
    @Test
    public void isHomePageLoaded() {
        open("http://the-internet.herokuapp.com/");
        assertTrue($(byText("Welcome to the-internet")).isDisplayed());
    }
}
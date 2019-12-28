package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class HomePageTests extends TestCase {
    @Test
    public void isHomePageLoaded() {
        open("http://the-internet.herokuapp.com/");
        $(byText("Welcome to the-internet")).should(appear);
    }
}
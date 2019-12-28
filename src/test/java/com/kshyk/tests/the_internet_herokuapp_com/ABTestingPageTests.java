package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class ABTestingPageTests extends TestCase {
    @Test
    public void isABTestPageLoaded() {
        open("http://the-internet.herokuapp.com/abtest");
        $(By.tagName("h3")).shouldHave(text("A/B Test"));
    }
}
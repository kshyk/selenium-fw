package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ABTestingPageTests extends TestCase {
    @Test
    public final void isABTestPageLoaded() {
        open("http://the-internet.herokuapp.com/abtest");
        $(By.tagName("h3")).shouldHave(text("A/B Test"));
    }
}
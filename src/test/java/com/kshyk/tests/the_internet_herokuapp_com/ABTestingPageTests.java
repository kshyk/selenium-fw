package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ABTestingPageTests extends TestCase {
    @Test
    public final void isABTestPageLoaded() {
        open("http://the-internet.herokuapp.com/");
        $("a[href='/abtest']").click();
        $(byText("A/B Test Variation 1")).should(appear);
    }
}
package com.kshyk.tests.pajacyk_pl;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class BellyClickTests extends TestCase {
    @Test
    void clickOnBellyTest() {
        open("https://www.pajacyk.pl/#index");
        $(".paj-click").click();
        $(byText("dziękujemy :)")).should(appear);
    }
}
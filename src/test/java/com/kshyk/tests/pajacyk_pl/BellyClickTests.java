package com.kshyk.tests.pajacyk_pl;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BellyClickTests extends TestCase {
    @Test
    public final void clickOnBellyTest() {
        open("https://www.pajacyk.pl/#index");
        $(".paj-click").hover();
        $(".paj-click2").click();
        $(byText("dziękujemy :)")).should(appear);
    }
}

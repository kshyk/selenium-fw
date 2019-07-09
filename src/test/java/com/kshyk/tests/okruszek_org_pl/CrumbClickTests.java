package com.kshyk.tests.okruszek_org_pl;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CrumbClickTests extends TestCase {
    @Test
    public final void clickOnCrumbTest() {
        open("http://www.okruszek.org.pl/");
        $(".click-crumb").click();
        $(byText("DZIĘKUJEMY!")).should(appear);
    }
}

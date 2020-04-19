package com.kshyk.pageobjects.pajacyk;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PajacykHomePage {
    public PajacykHomePage clickOnBelly() {
        $(".paj-click").click();
        return this;
    }

    public void thanksShouldAppear() {
        $(byText("dziękujemy :)")).should(appear)
                .shouldBe(visible);
    }
}
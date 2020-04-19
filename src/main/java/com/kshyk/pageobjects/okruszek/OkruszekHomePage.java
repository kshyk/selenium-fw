package com.kshyk.pageobjects.okruszek;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OkruszekHomePage {
    public OkruszekHomePage clickOnBread() {
        $(".click-crumb").click();
        return this;
    }

    public void thanksShouldAppear() {
        $(byText("DZIĘKUJEMY!")).should(appear)
                .shouldBe(visible);
    }
}
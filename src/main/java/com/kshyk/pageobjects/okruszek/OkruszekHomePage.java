package com.kshyk.pageobjects.okruszek;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OkruszekHomePage {
    public OkruszekHomePage clickOnBread() {
        $(".click-crumb").click();
        return this;
    }

    public boolean isThanksDisplayed() {
        return $(byText("DZIĘKUJEMY!")).shouldBe(visible)
                .isDisplayed();
    }
}
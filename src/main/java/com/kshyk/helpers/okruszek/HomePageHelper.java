package com.kshyk.helpers.okruszek;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePageHelper {
    private HomePageHelper() {
    }

    public static void clickOnBread() {
        $(".click-crumb").click();
    }

    public static boolean isThanksDisplayed() {
        return $(byText("DZIĘKUJEMY!")).shouldBe(visible)
                .isDisplayed();
    }
}
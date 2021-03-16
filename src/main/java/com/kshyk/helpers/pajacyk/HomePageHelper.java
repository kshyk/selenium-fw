package com.kshyk.helpers.pajacyk;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePageHelper {
    private HomePageHelper() {
    }

    public static void clickOnBelly() {
        $(".pajacyk__clickbox").click();
    }

    public static boolean isThanksDisplayed() {
        return $(byText("dziękujemy :)")).shouldBe(visible)
                .isDisplayed();
    }
}
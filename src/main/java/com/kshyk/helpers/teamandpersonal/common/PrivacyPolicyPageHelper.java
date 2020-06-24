package com.kshyk.helpers.teamandpersonal.common;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PrivacyPolicyPageHelper {
    private PrivacyPolicyPageHelper() {
    }

    public static boolean isOpen() {
        return $(".site-content").shouldBe(visible).isDisplayed();
    }
}
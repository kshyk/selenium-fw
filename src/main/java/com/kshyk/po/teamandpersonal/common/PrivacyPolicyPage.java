package com.kshyk.po.teamandpersonal.common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PrivacyPolicyPage {
    public SelenideElement content() {
        return $(".site-content");
    }

    public boolean isOpen() {
        return content().shouldBe(visible).isDisplayed();
    }
}

package com.kshyk.pageobjects.teamandpersonal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PrivacyPolicyPage {
    private final SelenideElement rootElement = $(".site-content");

    public PrivacyPolicyPage() {
        rootElement.shouldBe(visible);
    }

    public boolean isOpen() {
        return rootElement.is(visible);
    }
}

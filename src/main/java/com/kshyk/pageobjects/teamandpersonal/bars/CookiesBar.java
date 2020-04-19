package com.kshyk.pageobjects.teamandpersonal.bars;

import com.codeborne.selenide.SelenideElement;
import com.kshyk.pageobjects.teamandpersonal.common.PrivacyPolicyPage;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CookiesBar {
    private final SelenideElement cookieBar = $("div#catapult-cookie-bar");

    public PrivacyPolicyPage openPrivacyPolicyPage() {
        cookieBar.$(".ctcc-more-info-link")
                .click();
        switchTo().window(1);
        return new PrivacyPolicyPage();
    }

    public String getText() {
        return cookieBar.$(".ctcc-left-side")
                .getText();
    }

    public CookiesBar acceptCookies() {
        cookieBar.$("#catapultCookie")
                .click();
        return this;
    }

    public boolean isOpen() {
        return cookieBar.shouldBe(visible)
                .isDisplayed();
    }

    public boolean isClosed() {
        return !cookieBar.should(disappear)
                .isDisplayed();
    }
}
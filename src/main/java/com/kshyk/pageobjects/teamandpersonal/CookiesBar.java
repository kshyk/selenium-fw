package com.kshyk.pageobjects.teamandpersonal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CookiesBar {
    private final SelenideElement cookieBar = $("div#catapult-cookie-bar");

    public CookiesBar() {
        cookieBar.shouldBe(visible);
    }

    public PrivacyPolicyPage openPrivacyPolicyPage() {
        cookieBar.$(".ctcc-more-info-link").click();
        switchTo().window(1);
        return new PrivacyPolicyPage();
    }

    public String getText() {
        return cookieBar.$(".ctcc-left-side").text();
    }

    public CookiesBar acceptCookies() {
        cookieBar.$("#catapultCookie").hover().click();
        cookieBar.should(disappear);
        return this;
    }

    public boolean isClosed() {
        return cookieBar.is(hidden);
    }

    public boolean isOpen() {
        return cookieBar.is(visible);
    }
}

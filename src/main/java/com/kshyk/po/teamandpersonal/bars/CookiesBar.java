package com.kshyk.po.teamandpersonal.bars;

import com.codeborne.selenide.SelenideElement;
import com.kshyk.po.teamandpersonal.common.PrivacyPolicyPage;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CookiesBar {
    public SelenideElement bar() {
        return $("div#catapult-cookie-bar");
    }

    public PrivacyPolicyPage openPrivacyPolicyPage() {
        bar().$(".ctcc-more-info-link").click();
        switchTo().window(1);
        return new PrivacyPolicyPage();
    }

    public String getText() {
        return bar().$(".ctcc-left-side").getText();
    }

    public CookiesBar acceptCookies() {
        bar().$("#catapultCookie").click();
        return this;
    }

    public boolean isOpen() {
        return bar().shouldBe(visible).isDisplayed();
    }

    public boolean isClosed() {
        return !bar().should(disappear).isDisplayed();
    }
}

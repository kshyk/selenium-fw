package com.kshyk.helpers.teamandpersonal.bars;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CookiesBarHelper {
    private static final SelenideElement cookieBar = $("div#catapult-cookie-bar");

    private CookiesBarHelper() {
    }

    public static void openPrivacyPolicyPage() {
        cookieBar.$(".ctcc-more-info-link").click();
        switchTo().window(1);
    }

    public static String getText() {
        return cookieBar.$(".ctcc-left-side").text();
    }

    public static void acceptCookies() {
        cookieBar.$("#catapultCookie").click();
    }

    public static boolean isOpen() {
        return cookieBar.shouldBe(visible).isDisplayed();
    }

    public static boolean isClosed() {
        return !cookieBar.should(disappear).isDisplayed();
    }
}
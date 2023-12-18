package com.kshyk.pageobjects.teamandpersonal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CookiesBar {
    private final SelenideElement cookieBar = $("aside#moove_gdpr_cookie_info_bar");

    public CookiesBar() {
        cookieBar.shouldBe(visible);
    }

    public String getText() {
        return cookieBar.$(".moove-gdpr-cookie-notice").innerText().replace("\n", "");
    }

    public CookiesBar acceptCookies() {
        cookieBar.$(".moove-gdpr-infobar-allow-all").hover().click();
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

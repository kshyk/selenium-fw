package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.codeborne.selenide.Selenide;
import com.kshyk.enums.teamandpersonal.SocialMedia;
import com.kshyk.pageobjects.teamandpersonal.bars.NavigationBar;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.BDDAssertions.then;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NavigationBarTests extends TestCase {
    private static final String HOME_PAGE_URL = "https://teamandpersonal.pl/";
    private NavigationBar navigationBar;

    @BeforeAll
    public void openHomePage() {
        navigationBar = open(HOME_PAGE_URL, NavigationBar.class);
    }

    @Order(0)
    @Test
    public void checkTelephone() {
        navigationBar.telephoneShouldHaveText("+48 660 22 77 22");
    }

    @Order(0)
    @Test
    public void checkMail() {
        navigationBar.mailShouldHaveHrefValue("mailto:biuro@teamandpersonal.pl")
                .mailShouldHaveText("biuro [at] teamandpersonal.pl");
    }

    @Order(1)
    @ParameterizedTest(name = "checkRedirectionOf{0}")
    @EnumSource(SocialMedia.class)
    public void checkRedirectionOfSocialMedia(SocialMedia $) {
        if (!url().equals(HOME_PAGE_URL))
            Selenide.back();
        navigationBar.clickOnSocialMediaButton($);
        then(url()).startsWith($.getUrl());
    }
}
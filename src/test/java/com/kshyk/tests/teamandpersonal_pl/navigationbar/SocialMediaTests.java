package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.codeborne.selenide.Selenide;
import com.kshyk.enums.teamandpersonal.SocialMedia;
import com.kshyk.pageobjects.teamandpersonal.bars.NavigationBar;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.BDDAssertions.then;

class SocialMediaTests extends TestCase {
    private NavigationBar navigationBar;

    @BeforeAll
    public void openHomePage() {
        navigationBar = open("https://teamandpersonal.pl/", NavigationBar.class);
    }

    @AfterEach
    public void goBack() {
        Selenide.back();
    }

    @ParameterizedTest(name = "checkRedirectionOf{0}")
    @EnumSource(SocialMedia.class)
    public void checkRedirectionOfSocialMedia(SocialMedia $) {
        navigationBar.clickOnSocialMediaButton($);
        then(url()).startsWith($.getUrl());
    }
}
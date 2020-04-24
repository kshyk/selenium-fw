package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.codeborne.selenide.Selenide;
import com.kshyk.enums.teamandpersonal.SocialMedia;
import com.kshyk.pageobjects.teamandpersonal.bars.NavigationBar;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("+48 660 22 77 22", navigationBar.getTelephoneText());
    }

    @Order(0)
    @Test
    public void checkMail() {
        assertAll(() -> assertEquals("mailto:biuro@teamandpersonal.pl", navigationBar.getMailHrefValue()),
                () -> assertEquals("biuro [at] teamandpersonal.pl", navigationBar.getMailText()));
    }

    @Order(1)
    @ParameterizedTest(name = "checkRedirectionOf{0}")
    @EnumSource(SocialMedia.class)
    public void checkRedirectionOfSocialMedia(SocialMedia media) {
        if (!url().equals(HOME_PAGE_URL))
            Selenide.back();
        navigationBar.clickOnSocialMediaButton(media);
        assertThat(url()).startsWith(media.getUrl());
    }
}
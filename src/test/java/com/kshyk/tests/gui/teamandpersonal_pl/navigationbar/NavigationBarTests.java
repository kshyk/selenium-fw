package com.kshyk.tests.gui.teamandpersonal_pl.navigationbar;

import com.codeborne.selenide.Selenide;
import com.kshyk.enums.teamandpersonal.SocialMedia;
import com.kshyk.helpers.teamandpersonal.bars.NavigationBarHelper;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NavigationBarTests extends TestCase {
    private static final String HOME_PAGE_URL = "https://teamandpersonal.pl/";

    @BeforeAll
    void openHomePage() {
        open(HOME_PAGE_URL);
    }

    @Order(0)
    @Test
    void checkTelephone() {
        assertEquals("+48 660 22 77 22", NavigationBarHelper.getTelephoneText());
    }

    @Order(0)
    @Test
    void checkMailToHrefValue() {
        assertEquals("mailto:biuro@teamandpersonal.pl", NavigationBarHelper.getMailHrefValue());
    }

    @Order(0)
    @Test
    void checkMailText() {
        assertEquals("biuro [at] teamandpersonal.pl", NavigationBarHelper.getMailText());
    }

    @Order(1)
    @ParameterizedTest(name = "checkRedirectionOf{0}")
    @EnumSource(SocialMedia.class)
    void checkRedirectionOfSocialMedia(SocialMedia socialMedia) {
        if (!url().equals(HOME_PAGE_URL))
            Selenide.back();
        socialMedia.clickOnButton();
        assertThat(url()).startsWith(socialMedia.getUrl());
    }
}

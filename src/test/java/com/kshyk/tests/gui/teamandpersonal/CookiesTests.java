package com.kshyk.tests.gui.teamandpersonal;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.kshyk.pageobjects.teamandpersonal.CookiesBar;
import com.kshyk.pageobjects.teamandpersonal.HomePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.kshyk.common.Constants.COOKIES_TEXT;

class CookiesTests extends TNPTestCase {
    @BeforeAll
    void preconditions() {
        HomePage.open();
    }

    @Test
    void checkCookieBar() {
        var assertions = new SoftAssertions();
        var cookiesBar = new CookiesBar();
        assertions.assertThat(cookiesBar.isOpen()).as("Cookie Policy bar didn't appear").isTrue();
        assertions.assertThat(cookiesBar.getText()).as("Invalid Cookie Policy information text")
            .isEqualTo(COOKIES_TEXT);
        var privacyPolicyPage = cookiesBar.openPrivacyPolicyPage();
        assertions.assertThat(privacyPolicyPage.isOpen()).as("Privacy Policy page didn't appear").isTrue();
        assertions.assertThat(WebDriverRunner.url()).as("Invalid Privacy Policy page url")
            .contains("/polityka-prywatnosci");
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
        assertions.assertThat(cookiesBar.acceptCookies().isClosed())
            .as("Cookie Policy bar is still visible after close action").isTrue();
        assertions.assertAll();
    }
}

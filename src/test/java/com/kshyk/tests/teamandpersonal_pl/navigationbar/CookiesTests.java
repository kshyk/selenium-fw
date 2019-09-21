package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.google.common.collect.Iterables;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.assertj.core.api.BDDAssertions.then;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CookiesTests extends TestCase {
    @BeforeAll
    void openHomePage() {
        open("https://teamandpersonal.pl/");
    }

    @Test
    @Order(1)
    void checkCookieBarVisibilityOnStart() {
        $("div#catapult-cookie-bar").shouldBe(visible);
    }

    @Test
    @Order(1)
    void checkCookieBarInfo() {
        var expectedValue = "Serwis wykorzystuje pliki cookies. Korzystając ze strony wyrażasz zgodę na " +
                "wykorzystywanie plików cookies. dowiedz się więcej.";
        $(".ctcc-left-side").shouldHave(exactText(expectedValue));
    }

    @Test
    @Order(2)
    void clickGDPRLinkShouldOpenPolicyPage() {
        $(".ctcc-more-info-link").click();
        var driver = driver().getWebDriver();
        driver().switchTo().window(Iterables.getLast(driver.getWindowHandles()));
        $(".site-content").shouldBe(visible);
    }

    @Test
    @Order(3)
    void checkPrivacyPolicyUrl() {
        var privacyPolicyUrl = "https://teamandpersonal.pl/polityka-prywatnosci/";
        then(url()).isEqualTo(privacyPolicyUrl);
    }

    @Test
    @Order(4)
    void checkCookieBarInvisibilityAfterButtonClick() {
        getWebDriver().close();
        driver().switchTo().window(0);
        $("#catapultCookie").click();
        $("div#catapult-cookie-bar").should(disappear);
    }
}
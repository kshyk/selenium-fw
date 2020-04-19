package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.kshyk.pageobjects.teamandpersonal.bars.CookiesBar;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CookiesTests extends TestCase {
    private CookiesBar cookiesBar;

    @BeforeAll
    public void openHomePage() {
        cookiesBar = open("https://teamandpersonal.pl/", CookiesBar.class);
    }

    @Test
    @Order(1)
    public void checkCookieBarVisibilityOnStart() {
        assertTrue(cookiesBar.isOpen());
    }

    @Test
    @Order(1)
    public void checkCookieBarInfo() {
        assertEquals("Serwis wykorzystuje pliki cookies. Korzystając ze strony wyrażasz zgodę na wykorzystywanie plików cookies. dowiedz się więcej.", cookiesBar.getText());
    }

    @Test
    @Order(2)
    public void clickGDPRLinkShouldOpenPolicyPage() {
        assertTrue(cookiesBar.openPrivacyPolicyPage()
                .isOpen());
    }

    @Test
    @Order(3)
    public void checkPrivacyPolicyUrl() {
        assertEquals("https://teamandpersonal.pl/polityka-prywatnosci/", url());
    }

    @Test
    @Order(4)
    public void checkCookieBarInvisibilityAfterButtonClick() {
        closeWindow();
        switchTo().window(0);
        assertTrue(cookiesBar.acceptCookies()
                .isClosed());
    }
}
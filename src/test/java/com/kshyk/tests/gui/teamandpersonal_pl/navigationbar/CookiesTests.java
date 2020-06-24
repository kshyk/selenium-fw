package com.kshyk.tests.gui.teamandpersonal_pl.navigationbar;

import com.kshyk.helpers.teamandpersonal.bars.CookiesBarHelper;
import com.kshyk.helpers.teamandpersonal.common.PrivacyPolicyPageHelper;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CookiesTests extends TestCase {
    @BeforeAll
    public void openHomePage() {
        open("https://teamandpersonal.pl/");
    }

    @Test
    @Order(1)
    public void checkCookieBarVisibilityOnStart() {
        assertTrue(CookiesBarHelper.isOpen());
    }

    @Test
    @Order(1)
    public void checkCookieBarInfo() {
        var expected = "Serwis wykorzystuje pliki cookies. Korzystając ze strony wyrażasz zgodę na wykorzystywanie plików cookies. dowiedz się więcej.";
        assertEquals(expected, CookiesBarHelper.getText());
    }

    @Test
    @Order(2)
    public void clickGDPRLinkShouldOpenPolicyPage() {
        CookiesBarHelper.openPrivacyPolicyPage();
        assertTrue(PrivacyPolicyPageHelper.isOpen());
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
        CookiesBarHelper.acceptCookies();
        assertTrue(CookiesBarHelper.isClosed());
    }
}
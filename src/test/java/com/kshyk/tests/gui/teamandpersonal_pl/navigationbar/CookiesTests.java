package com.kshyk.tests.gui.teamandpersonal_pl.navigationbar;

import com.kshyk.helpers.teamandpersonal.bars.CookiesBarHelper;
import com.kshyk.helpers.teamandpersonal.common.PrivacyPolicyPageHelper;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CookiesTests extends TestCase {
    @BeforeAll
    void openHomePage() {
        open("https://teamandpersonal.pl/");
    }

    @Test
    @Order(1)
    void checkCookieBarVisibilityOnStart() {
        assertTrue(CookiesBarHelper.isOpen());
    }

    @Test
    @Order(1)
    void checkCookieBarInfo() {
        var expected = "Serwis wykorzystuje pliki cookies. Korzystając ze strony wyrażasz zgodę na wykorzystywanie plików cookies. dowiedz się więcej.";
        assertEquals(expected, CookiesBarHelper.getText());
    }

    @Test
    @Order(2)
    void clickGDPRLinkShouldOpenPolicyPage() {
        CookiesBarHelper.openPrivacyPolicyPage();
        assertTrue(PrivacyPolicyPageHelper.isOpen());
    }

    @Test
    @Order(3)
    void checkPrivacyPolicyUrl() {
        assertEquals("https://teamandpersonal.pl/polityka-prywatnosci/", url());
    }

    @Test
    @Order(4)
    void checkCookieBarInvisibilityAfterButtonClick() {
        closeWindow();
        switchTo().window(0);
        CookiesBarHelper.acceptCookies();
        assertTrue(CookiesBarHelper.isClosed());
    }
}

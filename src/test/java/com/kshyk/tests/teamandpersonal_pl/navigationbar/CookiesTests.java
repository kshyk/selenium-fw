package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.Iterables;
import com.kshyk.tests.base.TestCase;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.BDDAssertions.then;

public class CookiesTests extends TestCase {
    @BeforeClass
    public void openHomePage() {
        open("https://teamandpersonal.pl/");
    }

    @Test
    public void checkCookieBarVisibilityOnStart() {
        $("div#catapult-cookie-bar").shouldBe(visible);
    }

    @Test(dependsOnMethods = "checkCookieBarVisibilityOnStart")
    public void checkCookieBarInfo() {
        var expectedValue = "Serwis wykorzystuje pliki cookies. Korzystając ze strony wyrażasz zgodę na " +
                "wykorzystywanie plików cookies. dowiedz się więcej.";
        $(".ctcc-left-side").shouldHave(exactText(expectedValue));
    }

    @Test(groups = "GDPR policy", dependsOnMethods = "checkCookieBarVisibilityOnStart")
    public void checkGDPRLinkJumping() {
        $(".site-content").shouldBe(visible);
        var privacyPolicyUrl = "https://teamandpersonal.pl/polityka-prywatnosci/";
        var actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        then(actualUrl).isEqualTo(privacyPolicyUrl);
    }

    @BeforeGroups(groups = "GDPR policy")
    public void whenPrivacyPolicyPage() {
        $(".ctcc-more-info-link").click();
        var driver = WebDriverRunner.getWebDriver();
        driver.switchTo().window(Iterables.getLast(driver.getWindowHandles()));
    }

    @AfterGroups(groups = "GDPR policy")
    public void closePrivacyPolicyPage() {
        var driver = WebDriverRunner.getWebDriver();
        if (driver.getWindowHandles().size() > 1) {
            var firstTab = Iterables.getFirst(driver.getWindowHandles(), null);
            driver.close();
            driver.switchTo().window(firstTab);
        }
    }

    @Test(dependsOnMethods = "checkCookieBarInfo")
    public void checkCookieBarInvisibilityAfterButtonClick() {
        $("#catapultCookie").click();
        $("div#catapult-cookie-bar").should(disappear);
    }
}
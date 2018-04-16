package com.kshyk.tests.neobux_com;

import com.kshyk.po.neobux.*;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class EarnMoneyTests extends BaseTest {

    @Test()
    public void earnMoney_SuccessfulLogonProcess() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        loginPage.goToMemberLogin();
        loginPage.fillCredentials();
        if (loginPage.isCaptchaVisible()) {
            wait.until(bool -> loginPage.getCaptcha().getAttribute("value").length() == 5);
        }
        loginPage.send();
        wait.until(ExpectedConditions.visibilityOf(page.getInstance(SummaryPage.class).getClicksChart()));
    }

    @Test(dependsOnMethods = "earnMoney_SuccessfulLogonProcess")
    public void earnMoney_ClickOnEveryActiveAdvertisement() {
        AdvertisementsPage advertisementsPage = page.getInstance(Toolbar.class).goToViewAdvertisements();
        assertTrue(advertisementsPage.isOpened(), advertisementsPage.getClass().getSimpleName() + " is not visible.");
        advertisementsPage.getActiveAds().forEach(ad -> {
            advertisementsPage.clickOnActiveAdvertisement(ad);
            advertisementsPage.clickOnRedDot(By.className("redDTA"));
            page.getInstance(AdvertWindow.class).close();
        });
    }

    @Test(dependsOnMethods = "earnMoney_ClickOnEveryActiveAdvertisement")
    public void earnMoney_RunLotteryAfterAds() {

    }

}

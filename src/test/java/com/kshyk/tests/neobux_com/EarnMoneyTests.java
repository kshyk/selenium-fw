package com.kshyk.tests.neobux_com;

import com.kshyk.po.neobux.*;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class EarnMoneyTests extends BaseTest {

    @Test
    public void earnMoney_SuccessfulLogonProcess() {
        final LoginPage loginPO = getPage().getInstance(LoginPage.class);
        loginPO.goToMemberLogin();
        loginPO.fillCredentials();
        if (loginPO.isCaptchaVisible()) {
            getWait().until(bool -> loginPO.getCaptcha().getAttribute("value").length() == 5);
        }
        loginPO.send();
        getWait().until(ExpectedConditions.visibilityOf(getPage().getInstance(SummaryPage.class).getClicksChart()));
    }

    @Test(dependsOnMethods = "earnMoney_SuccessfulLogonProcess")
    public void earnMoney_ClickOnEveryActiveAdvertisement() {
        final AdvertisementsPage advertisementsPO = getPage().getInstance(Toolbar.class).goToViewAdvertisements();
        assertTrue(advertisementsPO.isOpened(), advertisementsPO.getClass().getSimpleName() + " is not visible.");
        advertisementsPO.getActiveAds().forEach(ad -> {
            advertisementsPO.clickOnActiveAdvertisement(ad);
            advertisementsPO.clickOnRedDot(By.className("redDTA"));
            getPage().getInstance(AdvertWindow.class).close();
        });
    }

    @Test(dependsOnMethods = "earnMoney_ClickOnEveryActiveAdvertisement")
    public void earnMoney_RunLotteryAfterAds() {
        final AdvertisementsPage advertisementsPO = getPage().getInstance(AdvertisementsPage.class);
        if (!advertisementsPO.isNullChancesVisible()) {
            final int repeats = advertisementsPO.getChances();
            advertisementsPO.clickOnChances();
            final AdvertWindow advertPO = getPage().getInstance(AdvertWindow.class);
            int counter = 1;
            while (counter != repeats) {
                advertPO.next();
                advertPO.sleep(5000);
                counter++;
            }
            advertPO.close();
        }
    }
}
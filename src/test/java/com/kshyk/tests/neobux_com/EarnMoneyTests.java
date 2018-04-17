package com.kshyk.tests.neobux_com;

import com.kshyk.po.neobux.*;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertTrue;

public class EarnMoneyTests extends BaseTest {

    @Test
    public void earnMoney_SuccessfulLogonProcess() {
        final LoginPage loginPO = page.getInstance(LoginPage.class);
        loginPO.goToMemberLogin();
        loginPO.fillCredentials();
        if (loginPO.isCaptchaVisible()) {
            wait.until(bool -> loginPO.getCaptcha().getAttribute("value").length() == 5);
        }
        loginPO.send();
        wait.until(ExpectedConditions.visibilityOf(page.getInstance(SummaryPage.class).getClicksChart()));
    }

    @Test(dependsOnMethods = "earnMoney_SuccessfulLogonProcess")
    public void earnMoney_ClickOnEveryActiveAdvertisement() {
        final AdvertisementsPage advertisementsPO = page.getInstance(Toolbar.class).goToViewAdvertisements();
        assertTrue(advertisementsPO.isOpened(), advertisementsPO.getClass().getSimpleName() + " is not visible.");
        advertisementsPO.getActiveAds().forEach(ad -> {
            advertisementsPO.clickOnActiveAdvertisement(ad);
            advertisementsPO.clickOnRedDot(By.className("redDTA"));
            page.getInstance(AdvertWindow.class).close();
        });
    }

    @Test(dependsOnMethods = "earnMoney_ClickOnEveryActiveAdvertisement")
    public void earnMoney_RunLotteryAfterAds() {
        final AdvertisementsPage advertisementsPO = page.getInstance(AdvertisementsPage.class);
        if (!advertisementsPO.isNullChancesVisible()) {
            final int repeats = advertisementsPO.getChances();
            advertisementsPO.clickOnChances();
            final AdvertWindow advertPO = page.getInstance(AdvertWindow.class);
            IntStream.range(0, repeats).forEach(x -> {
                advertPO.next();
                wait.until(ExpectedConditions.invisibilityOf(advertPO.getNext()));
            });
            advertPO.close();
        }
    }
}
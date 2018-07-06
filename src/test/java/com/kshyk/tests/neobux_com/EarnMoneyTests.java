package com.kshyk.tests.neobux_com;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.neobux.AdvertWindow;
import com.kshyk.po.neobux.AdvertisementsPage;
import com.kshyk.po.neobux.LoginPage;
import com.kshyk.po.neobux.SummaryPage;
import com.kshyk.po.neobux.Toolbar;
import com.kshyk.tests.base.BaseTest;

public class EarnMoneyTests extends BaseTest {
	
	@Test
	public void successfulLogonProcess() {
		final LoginPage loginPO = this.getPage().getInstance(LoginPage.class);
		loginPO.goToMemberLogin();
		loginPO.fillCredentials();
		if (loginPO.isCaptchaVisible()) {
			this.getWait().until(bool -> loginPO.getCaptcha().getAttribute("value").length() == 5);
		}
		loginPO.send();
		this.getWait().until(ExpectedConditions.visibilityOf(this.getPage().getInstance(SummaryPage.class).getClicksChart()));
	}
	
	@Test(dependsOnMethods = "successfulLogonProcess")
	public void clickOnEveryActiveAdvertisement() {
		final AdvertisementsPage advertisementsPO = this.getPage().getInstance(Toolbar.class).goToViewAdvertisements();
		assertTrue(advertisementsPO.isOpened(), advertisementsPO.getClass().getSimpleName() + " is not visible.");
		advertisementsPO.getActiveAds().forEach(ad -> {
			advertisementsPO.clickOnActiveAdvertisement(ad);
			advertisementsPO.clickOnRedDot(By.className("redDTA"));
			this.getPage().getInstance(AdvertWindow.class).close();
		});
	}
	
	@Test(dependsOnMethods = "clickOnEveryActiveAdvertisement")
	public void runLotteryAfterAds() {
		final AdvertisementsPage advertisementsPO = this.getPage().getInstance(AdvertisementsPage.class);
		if (!advertisementsPO.isNullChancesVisible()) {
			final int repeats = advertisementsPO.getChances();
			advertisementsPO.clickOnChances();
			final AdvertWindow advertPO = this.getPage().getInstance(AdvertWindow.class);
			int counter = 1;
			while (counter != repeats) {
				advertPO.next();
				advertPO.sleep(3500);
				counter++;
			}
			advertPO.close();
		}
	}
}
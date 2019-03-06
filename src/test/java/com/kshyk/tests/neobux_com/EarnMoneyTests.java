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

class EarnMoneyTests extends BaseTest {
	
	@Test(groups = "log into neobux")
	public final void successfulLogonProcess() {
		final var loginPO = this.getPage().getInstance(LoginPage.class)
				.goToMemberLogin()
				.fillCredentials();
		if (loginPO.isCaptchaVisible()) {
			this.getWait().until(bool -> loginPO.getCaptcha().getAttribute("value").length() == 5);
		}
		loginPO.send();
		this.getWait().until(ExpectedConditions.visibilityOf(this.getPage().getInstance(SummaryPage.class).getClicksChart()));
	}
	
	@Test(groups = "clicking on ads", dependsOnGroups = "log into neobux")
	public final void clickOnEveryActiveAdvertisement() {
		final var toolbar = this.getPage().getInstance(Toolbar.class);
		final var advertisementsPO = toolbar
				.goToViewAdvertisements();
		assertTrue(advertisementsPO.isOpened(), advertisementsPO.getClass().getSimpleName() + " is not visible.");
		advertisementsPO.getActiveAds().forEach(ad -> {
			advertisementsPO
					.clickOnActiveAdvertisement(ad)
					.clickOnRedDot(By.cssSelector(".redDTA img"));
			final var advertWindow = this.getPage().getInstance(AdvertWindow.class);
			advertWindow.close();
		});
	}
	
	@Test(dependsOnGroups = {"log into neobux", "clicking on ads"})
	public final void runLotteryAfterAds() {
		final var advertisementsPO = this.getPage().getInstance(AdvertisementsPage.class);
		if (!advertisementsPO.isNullChancesVisible()) {
			final int repeats = advertisementsPO.getChances();
			advertisementsPO.clickOnChances();
			final var advertPO = this.getPage().getInstance(AdvertWindow.class);
			int counter = 1;
			while (counter != repeats) {
				advertPO.next();
				counter++;
			}
			advertPO.close();
		}
	}
}
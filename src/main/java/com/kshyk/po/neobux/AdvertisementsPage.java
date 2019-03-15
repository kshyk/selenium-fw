package com.kshyk.po.neobux;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class AdvertisementsPage extends AbstractPage {
	
	@FindBy(id = "sInf0")
	private WebElement resetInfoBar;
	@FindBy(css = ".adfu,.adf,.ad5,.ad15,.ad30")
	private List<WebElement> activeAds;
	@FindBy(id = "ap_h")
	private WebElement adChances;
	
	public AdvertisementsPage(final WebDriver driver) {
		super(driver);
	}
	
	public final boolean isOpened() {
		return this.resetInfoBar.isDisplayed();
	}
	
	public final List<WebElement> getActiveAds() {
		return Collections.unmodifiableList(this.activeAds);
	}
	
	public final <T> AdvertisementsPage clickOnActiveAdvertisement(final T activeAd) {
		this.basePage.sleep(1500);
		this.basePage.mouseOverAndClick(activeAd);
		this.basePage.sleep(1000);
		return this;
	}
	
	public final void clickOnRedDot(final By dotElem) {
		this.basePage.sleep(1000);
		this.basePage.clickFirstVisibleElement(dotElem);
		this.basePage.switchToLastTab();
		this.basePage.sleep(1000);
	}
	
	public final int getChances() {
		return Integer.parseInt(this.adChances.getAttribute("textContent"));
	}
	
	public final boolean isNullChancesVisible() {
		return this.basePage.isElementPresent(By.id("ap_hct0"));
	}
	
	public final void clickOnChances() {
		this.basePage.sleep(1500);
		this.basePage.mouseOverAndClick(this.adChances);
		this.basePage.switchToLastTab();
		this.basePage.sleep(1000);
	}
	
}

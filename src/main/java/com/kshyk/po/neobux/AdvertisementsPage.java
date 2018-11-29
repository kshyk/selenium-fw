package com.kshyk.po.neobux;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.collect.Iterables;
import com.kshyk.core.BasePage;

public class AdvertisementsPage {
	
	private final BasePage basePage;
	private final WebDriver driver;
	@FindBy(id = "sInf0")
	private WebElement resetInfoBar;
	@FindBy(css = ".adfu,.adf,.ad5,.ad15,.ad30")
	private List<WebElement> activeAds;
	@FindBy(id = "ap_h")
	private WebElement adChances;
	
	public AdvertisementsPage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final boolean isOpened() {
		return this.resetInfoBar.isDisplayed();
	}
	
	public final List<WebElement> getActiveAds() {
		return Collections.unmodifiableList(this.activeAds);
	}
	
	public final <T> void clickOnActiveAdvertisement(final T activeAd) {
		this.basePage.sleep(1500);
		this.basePage.mouseOverAndClick(activeAd);
		this.basePage.sleep(1000);
	}
	
	public final void clickOnRedDot(final By dotElem) {
		this.basePage.sleep(1000);
		this.basePage.clickFirstVisibleElement(dotElem);
		this.driver.switchTo().window(Iterables.getLast(this.driver.getWindowHandles()));
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
		this.driver.getWindowHandles().forEach(handle -> this.driver.switchTo().window(handle));
	}
	
	public final void sleep(final int millis) {
		this.basePage.sleep(millis);
	}
}
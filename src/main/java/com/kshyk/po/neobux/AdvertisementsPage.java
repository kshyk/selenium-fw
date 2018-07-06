package com.kshyk.po.neobux;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class AdvertisementsPage extends BasePage {

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

	public List<WebElement> getActiveAds() {
		return this.activeAds;
	}

	public <T> void clickOnActiveAdvertisement(final T activeAd) {
		this.sleep(1500);
		this.mouseOverAndClick(activeAd);
	}

	public void clickOnRedDot(final By dotElem) {
		this.sleep(1000);
		this.clickFirstVisibleElement(dotElem);
		this.getDriver().getWindowHandles().forEach(handle -> this.getDriver().switchTo().window(handle));
	}

	public int getChances() {
		return Integer.parseInt(this.adChances.getAttribute("textContent"));
	}

	public boolean isNullChancesVisible() {
		return this.isElementPresent(By.id("ap_hct0"));
	}

	public void clickOnChances() {
		this.sleep(1500);
		this.mouseOverAndClick(this.adChances);
		this.getDriver().getWindowHandles().forEach(handle -> this.getDriver().switchTo().window(handle));
	}
}

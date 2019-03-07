package com.kshyk.po.teamandpersonal;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class CookiesBar {
	
	private final BasePage basePage;
	private final WebDriver driver;
	@CacheLookup
	@FindBy(css = "div#catapult-cookie-bar")
	private WebElement cookieBar;
	
	public CookiesBar(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final String getCookieInfoText() {
		final var byElement = By.className("ctcc-left-side");
		return this.basePage.readText(this.cookieBar.findElement(byElement));
	}
	
	public final void clickOnIUnderstandButton() {
		final var byElement = By.id("catapultCookie");
		final var webElement = this.cookieBar.findElement(byElement);
		this.basePage.click(webElement);
		this.basePage.getWaitShort().until(invisibilityOf(webElement));
	}
	
	public final void clickOnPrivacyPolicyLink() {
		final var byElement = By.className("ctcc-more-info-link");
		final var webElement = this.cookieBar.findElement(byElement);
		this.basePage.click(webElement);
	}
	
	public final boolean isOpen() {
		return this.basePage.isElementDisplayed(this.cookieBar);
	}
}

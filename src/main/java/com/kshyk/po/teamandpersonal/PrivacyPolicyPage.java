package com.kshyk.po.teamandpersonal;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class PrivacyPolicyPage {
	
	private final String URL = "https://teamandpersonal.pl/polityka-prywatnosci/";
	private final BasePage basePage;
	private final WebDriver driver;
	@FindBy(css = ".site-content")
	private WebElement siteContent;
	
	public PrivacyPolicyPage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final void open() {
		this.driver.get(this.URL);
	}
	
	public final String getURL() {
		return this.URL;
	}
	
	public WebElement getSiteContent() {
		return this.siteContent;
	}
	
	public final PrivacyPolicyPage waitForPrivacyPolicyPage() {
		this.basePage.getWaitShort()
				.until(visibilityOf(this.siteContent));
		return this;
	}
}

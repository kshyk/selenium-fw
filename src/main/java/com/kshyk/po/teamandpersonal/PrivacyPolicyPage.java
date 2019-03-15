package com.kshyk.po.teamandpersonal;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class PrivacyPolicyPage extends AbstractPage {
	
	private static final String URL = "https://teamandpersonal.pl/polityka-prywatnosci/";
	@FindBy(css = ".site-content")
	private WebElement siteContent;
	
	public PrivacyPolicyPage(final WebDriver driver) {
		super(driver);
	}
	
	public final String getURL() {
		return URL;
	}
	
	public final PrivacyPolicyPage waitForPrivacyPolicyPage() {
		this.basePage.getWaitShort()
				.until(visibilityOf(this.siteContent));
		return this;
	}
}

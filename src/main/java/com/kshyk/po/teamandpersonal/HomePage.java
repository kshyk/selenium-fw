package com.kshyk.po.teamandpersonal;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class HomePage extends AbstractPage {
	
	@FindBy(css = ".site-content")
	private WebElement siteContent;
	
	public HomePage(final WebDriver driver) {
		super(driver);
	}
	
	public final void open() {
		this.driver.get("https://teamandpersonal.pl/");
	}
	
	public final void waitForHomePage() {
		this.basePage.getWaitShort()
				.until(visibilityOf(this.siteContent));
	}
}

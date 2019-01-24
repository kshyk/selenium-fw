package com.kshyk.po.teamandpersonal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class HomePage {
	
	private final BasePage basePage;
	private final WebDriver driver;
	@FindBy(css = ".site-content")
	private WebElement siteContent;
	
	public HomePage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final HomePage open() {
		this.driver.get("https://teamandpersonal.pl/");
		return this;
	}
	
	public WebElement getSiteContent() {
		return this.siteContent;
	}
}

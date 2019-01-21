package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class AbTestPage {
	
	private final BasePage basePage;
	@FindBy(xpath = "//*[contains(text(),'A/B Test')]")
	private WebElement title;
	
	public AbTestPage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
	}
	
	public final boolean isOpen() {
		return this.basePage.isElementDisplayed(this.title);
	}
}

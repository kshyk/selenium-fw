package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class AbTestPage extends AbstractPage {
	
	@FindBy(xpath = "//*[contains(text(),'A/B Test')]")
	private WebElement title;
	
	public AbTestPage(final WebDriver driver) {
		super(driver);
	}
	
	public final boolean isOpen() {
		return this.basePage.isElementDisplayed(this.title);
	}
}

package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class ABTestPage extends BasePage {

	@FindBy(xpath = "//*[contains(text(),'A/B Test')]")
	private WebElement title;

	public ABTestPage(final WebDriver driver) {
		super(driver);
	}

	public final boolean isOpen() {
		return this.title.isDisplayed();
	}
}

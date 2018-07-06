package com.kshyk.po.okruszek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class HomePage extends BasePage {

	@FindBy(css = ".click-crumb")
	private WebElement crumb;

	public HomePage(final WebDriver driver) {
		super(driver);
	}

	public final void goToOkruszek() {
		this.getDriver().get("http://www.okruszek.org.pl/");
	}

	public final void clickOnCrumb() {
		this.mouseOverAndClick(this.crumb);
	}
}

package com.kshyk.po.neobux;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class Toolbar extends AbstractPage {
	
	@FindBy(id = "navAds")
	private WebElement viewAdvertisements;
	
	public Toolbar(final WebDriver driver) {
		super(driver);
	}
	
	public final void clickOnViewAdvertisementsLink() {
		this.basePage.mouseOverAndClick(this.viewAdvertisements);
	}
}

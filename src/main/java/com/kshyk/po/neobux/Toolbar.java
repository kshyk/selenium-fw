package com.kshyk.po.neobux;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kshyk.core.BasePage;

public class Toolbar extends BasePage {

	@FindBy(id = "navAds")
	private WebElement viewAdvertisements;

	public Toolbar(final WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public final AdvertisementsPage goToViewAdvertisements() {
		this.mouseOverAndClick(this.viewAdvertisements);
		return PageFactory.initElements(this.getDriver(), AdvertisementsPage.class);
	}
}

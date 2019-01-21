package com.kshyk.po.neobux;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kshyk.core.BasePage;

public class Toolbar {
	
	private final WebDriver driver;
	private final BasePage basePage;
	@FindBy(id = "navAds")
	private WebElement viewAdvertisements;
	
	public Toolbar(final WebDriver driver) {
		this.driver = driver;
		this.basePage = new BasePage(driver);
		PageFactory.initElements(driver, this);
	}
	
	public final AdvertisementsPage goToViewAdvertisements() {
		this.basePage.mouseOverAndClick(this.viewAdvertisements);
		return PageFactory.initElements(this.driver, AdvertisementsPage.class);
	}
}

package com.kshyk.po.toolsqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class DemoAlertsPage extends AbstractPage {
	
	@FindBy(css = "button[onclick*='pushAlert()']")
	private WebElement simpleAlertButton;
	@FindBy(css = "button[onclick*='pushConfirm()']")
	private WebElement confirmAlertButton;
	@FindBy(css = "button[onclick*='promptConfirm()']")
	private WebElement promptAlertButton;
	
	public DemoAlertsPage(final WebDriver driver) {
		super(driver);
	}
	
	public final void goToDemoAlerts() {
		this.driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
	}
	
	public final void pressSimpleAlertButton() {
		this.basePage.mouseOverAndClick(this.simpleAlertButton);
	}
	
	public final void pressConfirmAlertButton() {
		this.basePage.mouseOverAndClick(this.confirmAlertButton);
	}
	
	public final void pressPromptAlertButton() {
		this.basePage.mouseOverAndClick(this.promptAlertButton);
	}
}

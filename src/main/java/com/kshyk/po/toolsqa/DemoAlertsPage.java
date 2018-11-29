package com.kshyk.po.toolsqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kshyk.core.BasePage;

public class DemoAlertsPage {
	
	private final WebDriver driver;
	private final BasePage basePage;
	@FindBy(css = "button[onclick='pushAlert()']")
	private WebElement simpleAlertButton;
	@FindBy(css = "button[onclick='pushConfirm()']")
	private WebElement confirmAlertButton;
	@FindBy(css = "button[onclick='promptConfirm()']")
	private WebElement promptAlertButton;
	
	public DemoAlertsPage(final WebDriver driver) {
		this.driver = driver;
		this.basePage = new BasePage(driver);
		PageFactory.initElements(driver, this);
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
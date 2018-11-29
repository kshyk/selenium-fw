package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class HomePage {
	
	private final BasePage basePage;
	private final WebDriver driver;
	@FindBy(xpath = "//*[text()='Welcome to the-internet']")
	private WebElement title;
	@FindBy(css = "a[href='/abtest']")
	private WebElement abTestingLink;
	@FindBy(css = "a[href='/key_presses']")
	private WebElement keyPressesLink;
	@FindBy(css = "a[href='/upload']")
	private WebElement fileUploadLink;
	@FindBy(css = "a[href='/hovers']")
	private WebElement hoversLink;
	@FindBy(css = "a[href='/forgot_password']")
	private WebElement forgotPasswordLink;
	@FindBy(css = "a[href='/javascript_alerts']")
	private WebElement jsAlertsLink;
	@FindBy(css = "a[href='/windows']")
	private WebElement multipleWindowsLink;
	@FindBy(css = "a[href='/tinymce']")
	private WebElement tinyMCELink;
	@FindBy(css = "a[href='/nested_frames']")
	private WebElement nestedFramesLink;
	
	public HomePage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final HomePage goToHerokuapp() {
		this.driver.get("http://the-internet.herokuapp.com/");
		return this;
	}
	
	public final void goToABTest() {
		this.basePage.click(this.abTestingLink);
	}
	
	public final void goToKeyPresses() {
		this.basePage.click(this.keyPressesLink);
	}
	
	public final void goToFileUpload() {
		this.basePage.click(this.fileUploadLink);
	}
	
	public final void goToHovers() {
		this.basePage.click(this.hoversLink);
	}
	
	public final void goToForgotPassword() {
		this.basePage.click(this.forgotPasswordLink);
	}
	
	public final void goToJSAlerts() {
		this.basePage.click(this.jsAlertsLink);
	}
	
	public final void goToMultipleWindows() {
		this.basePage.click(this.multipleWindowsLink);
	}
	
	public final void goToTinyMCE() {
		this.basePage.click(this.tinyMCELink);
	}
	
	public final void goToNestedFrames() {
		this.basePage.click(this.nestedFramesLink);
	}
	
	public final boolean isOpen() {
		return this.title.isDisplayed();
	}
	
}

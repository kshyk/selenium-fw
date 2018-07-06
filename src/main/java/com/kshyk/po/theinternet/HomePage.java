package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class HomePage extends BasePage {

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
		super(driver);
	}

	public final void goToHerokuapp() {
		this.getDriver().get("http://the-internet.herokuapp.com/");
	}

	public final void goToABTest() {
		this.click(this.abTestingLink);
	}

	public final void goToKeyPresses() {
		this.click(this.keyPressesLink);
	}

	public final void goToFileUpload() {
		this.click(this.fileUploadLink);
	}

	public final void goToHovers() {
		this.click(this.hoversLink);
	}

	public final void goToForgotPassword() {
		this.click(this.forgotPasswordLink);
	}

	public final void goToJSAlerts() {
		this.click(this.jsAlertsLink);
	}

	public final void goToMultipleWindows() {
		this.click(this.multipleWindowsLink);
	}

	public final void goToTinyMCE() {
		this.click(this.tinyMCELink);
	}

	public final void goToNestedFrames() {
		this.click(this.nestedFramesLink);
	}

	public final boolean isOpen() {
		return this.title.isDisplayed();
	}

}

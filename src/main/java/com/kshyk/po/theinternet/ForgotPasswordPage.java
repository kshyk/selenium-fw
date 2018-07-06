package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class ForgotPasswordPage extends BasePage {

	@FindBy(xpath = "//*[text()='Forgot Password']")
	private WebElement title;

	@FindBy(id = "email")
	private WebElement emailInput;

	@FindBy(id = "form_submit")
	private WebElement retrievePasswordButton;

	public ForgotPasswordPage(final WebDriver driver) {
		super(driver);
	}

	private void pressRetrieveButton() {
		this.retrievePasswordButton.click();
	}

	private void typeEmail(final String email) {
		this.emailInput.clear();
		this.emailInput.sendKeys(email);
	}

	public final void resetPassword(final String email) {
		this.typeEmail(email);
		this.pressRetrieveButton();
	}

	public final boolean isOpen() {
		return this.title.isDisplayed();
	}
}

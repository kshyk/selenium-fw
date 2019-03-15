package com.kshyk.po.n11;

import static org.assertj.core.api.BDDAssertions.then;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class LoginPage extends AbstractPage {
	
	@FindBy(id = "email")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	@FindBy(css = "[data-errormessagefor='email'] .errorText")
	private WebElement errorMessageUsername;
	@FindBy(css = "[data-errormessagefor='password'] .errorText")
	private WebElement errorMessagePassword;
	
	public LoginPage(final WebDriver driver) {
		super(driver);
	}
	
	public final void loginToN11(final String uName, final String passwd) {
		this.basePage.writeText(this.username, uName);
		this.basePage.writeText(this.password, passwd);
		this.basePage.click(this.loginButton);
	}
	
	public final void verifyLoginUserName(final String expectedText) {
		then(this.basePage.readText(this.errorMessageUsername)).isEqualTo(expectedText);
	}
	
	public final void verifyLoginPassword(final String expectedText) {
		then(this.basePage.readText(this.errorMessagePassword)).isEqualTo(expectedText);
	}
}

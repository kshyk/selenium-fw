package com.kshyk.po.n11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kshyk.core.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(className = "btnSignIn")
	private WebElement signInButton;
	
	public HomePage(final WebDriver driver) {
		super(driver);
	}
	
	public final void goToN11() {
		this.getDriver().get("http://www.n11.com/");
	}
	
	public final LoginPage goToLoginPage() {
		this.click(this.signInButton);
		return PageFactory.initElements(this.getDriver(), LoginPage.class);
	}
	
}
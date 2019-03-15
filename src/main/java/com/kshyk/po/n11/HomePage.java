package com.kshyk.po.n11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class HomePage extends AbstractPage {
	
	@FindBy(className = "btnSignIn")
	private WebElement signInButton;
	
	public HomePage(final WebDriver driver) {
		super(driver);
	}
	
	public final HomePage open() {
		this.driver.get("http://www.n11.com/");
		return this;
	}
	
	public final void clickOnSignInButton() {
		this.basePage.click(this.signInButton);
	}
}

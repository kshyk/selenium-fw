package com.kshyk.po.n11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kshyk.core.BasePage;

public class HomePage {
	
	private final WebDriver driver;
	private final BasePage basePage;
	@FindBy(className = "btnSignIn")
	private WebElement signInButton;
	
	public HomePage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final HomePage goToN11() {
		this.driver.get("http://www.n11.com/");
		return this;
	}
	
	public final LoginPage goToLoginPage() {
		this.basePage.click(this.signInButton);
		return PageFactory.initElements(this.driver, LoginPage.class);
	}
}

package com.kshyk.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private final String baseURL = "http://www.n11.com/";
    @FindBy(className = "btnSignIn")
    public WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToN11() {
        driver.get(baseURL);
    }

    public LoginPage goToLoginPage() {
        click(signInButton);
        //I want to chain LoginPage's methods so I return LoginPage by initializing its elements
        return PageFactory.initElements(driver, LoginPage.class);
    }

}
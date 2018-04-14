package com.kshyk.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "loginButton")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div[1]/div/div")
    public WebElement errorMessageUsername;
    @FindBy(xpath = "//*[@id=\"loginForm\"]/div[2]/div/div")
    public WebElement errorMessagePassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToN11(String pusername, String ppassword) {
        writeText(username, pusername);
        writeText(password, ppassword);
        click(loginButton);
    }

    public void verifyLoginUserName(String expectedText) {
        Assert.assertEquals(readText(errorMessageUsername), expectedText);
    }

    public void verifyLoginPassword(String expectedText) {
        Assert.assertEquals(readText(errorMessagePassword), expectedText);
    }
}

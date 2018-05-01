package com.kshyk.po.n11;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

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

    public final void loginToN11(final String username, final String password) {
        writeText(this.username, username);
        writeText(this.password, password);
        click(this.loginButton);
    }

    public final void verifyLoginUserName(final String expectedText) {
        Assert.assertEquals(readText(this.errorMessageUsername), expectedText);
    }

    public final void verifyLoginPassword(final String expectedText) {
        Assert.assertEquals(readText(this.errorMessagePassword), expectedText);
    }
}

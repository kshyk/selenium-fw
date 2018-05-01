package com.kshyk.po.n11;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(className = "btnSignIn")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public final void goToN11() {
        getDriver().get("http://www.n11.com/");
    }

    public final LoginPage goToLoginPage() {
        click(signInButton);
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

}
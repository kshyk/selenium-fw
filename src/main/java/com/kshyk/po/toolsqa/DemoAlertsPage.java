package com.kshyk.po.toolsqa;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoAlertsPage extends BasePage {

    @FindBy(css = "button[onclick='pushAlert()']")
    private WebElement simpleAlertButton;

    @FindBy(css = "button[onclick='pushConfirm()']")
    private WebElement confirmAlertButton;

    @FindBy(css = "button[onclick='promptConfirm()']")
    private WebElement promptAlertButton;

    public DemoAlertsPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public final void goToDemoAlerts() {
        getDriver().get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
    }

    public final void pressSimpleAlertButton() {
        mouseOverAndClick(simpleAlertButton);
    }

    public final void pressConfirmAlertButton() {
        mouseOverAndClick(confirmAlertButton);
    }

    public final void pressPromptAlertButton() {
        mouseOverAndClick(promptAlertButton);
    }


}

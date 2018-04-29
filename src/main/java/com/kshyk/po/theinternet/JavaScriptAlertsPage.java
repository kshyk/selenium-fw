package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(xpath = "//*[text()='JavaScript Alerts']")
    private WebElement title;

    @FindBy(css = "[onclick='jsAlert()']")
    private WebElement alertButton;

    @FindBy(css = "[onclick='jsConfirm()']")
    private WebElement confirmButton;

    @FindBy(css = "[onclick='jsPrompt()']")
    private WebElement promptButton;

    @FindBy(id = "result")
    private WebElement result;

    public JavaScriptAlertsPage(final WebDriver driver) {
        super(driver);
    }

    public void alert() {
        this.alertButton.click();
    }

    public void confirm() {
        this.confirmButton.click();
    }

    public void prompt() {
        this.promptButton.click();
    }

    public String getResult() {
        return this.result.getText();
    }

    public boolean isOpen() {
        return this.title.isDisplayed();
    }
}

package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[text()='Welcome to the-internet']")
    private WebElement title;

    @FindBy(css = "a[href='/abtest']")
    private WebElement abTestingLink;

    @FindBy(css = "a[href='/key_presses']")
    private WebElement keyPressesLink;

    @FindBy(css = "a[href='/upload']")
    private WebElement fileUploadLink;

    @FindBy(css = "a[href='/hovers']")
    private WebElement hoversLink;

    @FindBy(css = "a[href='/forgot_password']")
    private WebElement forgotPasswordLink;

    @FindBy(css = "a[href='/javascript_alerts']")
    private WebElement jsAlertsLink;

    @FindBy(css = "a[href='/windows']")
    private WebElement multipleWindowsLink;

    @FindBy(css = "a[href='/tinymce']")
    private WebElement tinyMCELink;

    public HomePage(final WebDriver driver) {
        super(driver);
    }

    public final void goToHerokuapp() {
        getDriver().get("http://the-internet.herokuapp.com/");
    }

    public final void goToABTest() {
        click(abTestingLink);
    }

    public final void goToKeyPresses() {
        click(keyPressesLink);
    }

    public final void goToFileUpload() {
        click(fileUploadLink);
    }

    public final void goToHovers() {
        click(hoversLink);
    }

    public final void goToForgotPassword() {
        click(forgotPasswordLink);
    }

    public final void goToJSAlerts() {
        click(jsAlertsLink);
    }

    public final void goToMultipleWindows() {
        click(multipleWindowsLink);
    }

    public final void goToTinyMCE() {
        click(tinyMCELink);
    }

    public final boolean isOpen() {
        return this.title.isDisplayed();
    }

}

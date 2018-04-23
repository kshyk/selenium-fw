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

    public HomePage(final WebDriver driver) {
        super(driver);
    }

    public void goToHerokuapp() {
        this.driver.get("http://the-internet.herokuapp.com/");
    }

    public void goToABTest() {
        click(abTestingLink);
    }

    public void goToKeyPresses() {
        click(keyPressesLink);
    }

    public void goToFileUpload() {
        click(fileUploadLink);
    }

    public boolean isOpen() {
        return this.title.isDisplayed();
    }

}

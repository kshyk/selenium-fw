package com.kshyk.po.theinternet;

import com.kshyk.po.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[text()='Welcome to the-internet']")
    private WebElement title;
    @FindBy(css = "a[href='/key_presses']")
    private WebElement keyPressesLink;

    public HomePage(final WebDriver driver) {
        super(driver);
    }

    public final HomePage goToHerokuapp() {
        this.driver.get("http://the-internet.herokuapp.com/");
        return this;
    }

    public final void goToKeyPresses() {
        this.basePage.click(this.keyPressesLink);
    }

    public final boolean isOpen() {
        return this.title.isDisplayed();
    }

}

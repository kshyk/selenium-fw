package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindowsPage extends BasePage {

    @FindBy(xpath = "//*[text()='Opening a new window']")
    private WebElement title;

    @FindBy(xpath = "//a[text()='Click Here']")
    private WebElement newWindowLink;

    public MultipleWindowsPage(final WebDriver driver) {
        super(driver);
    }

    public final boolean isOpen() {
        return this.title.isDisplayed();
    }

    public final void openNewWindow() {
        this.newWindowLink.click();
    }
}
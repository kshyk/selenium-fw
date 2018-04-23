package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABTestPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'A/B Test')]")
    private WebElement title;

    public ABTestPage(final WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return title.isDisplayed();
    }
}

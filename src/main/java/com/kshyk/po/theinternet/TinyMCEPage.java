package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TinyMCEPage extends BasePage {

    @FindBy(xpath = "//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")
    private WebElement title;

    public TinyMCEPage(final WebDriver driver) {
        super(driver);
    }

    public final boolean isOpen() {
        return this.title.isDisplayed();
    }

}
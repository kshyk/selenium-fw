package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends BasePage {

    @FindBy(xpath = "//*[text()='Key Presses']")
    private WebElement title;

    @FindBy(id = "result")
    private WebElement result;

    public KeyPressesPage(final WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return this.title.isDisplayed();
    }

    public String pressKeyAndGetResult(final Keys key) {
        this.pressKey(key);
        return this.getResult();
    }

    private String getResult() {
        return this.result.getText();
    }


}

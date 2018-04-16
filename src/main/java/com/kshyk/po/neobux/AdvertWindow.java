package com.kshyk.po.neobux;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvertWindow extends BasePage {

    @FindBy(css = "[onclick='wClose()']")
    private WebElement close;

    public AdvertWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void close() {
        new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(close)).click();
        String firstTab = driver.getWindowHandles().stream().findFirst().get();
        driver.switchTo().window(firstTab);
    }
}

package com.kshyk.po.neobux;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvertWindow extends BasePage {

    private final WebDriverWait wait;
    @FindBy(css = "[onclick='wClose()']")
    private WebElement close;
    @FindBy(id = "nxt_bt_a")
    private WebElement next;

    public AdvertWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 90);
    }

    public final void close() {
        wait.until(ExpectedConditions.visibilityOf(close)).click();
        String firstTab = getDriver().getWindowHandles().stream().findFirst().orElse(null);
        getDriver().switchTo().window(firstTab);
    }

    public final void next() {
        wait.until(ExpectedConditions.visibilityOf(next)).click();
    }

}
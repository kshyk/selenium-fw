package com.kshyk.po.pajacyk;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "paj-click")
    private WebElement greenBellyBefore;
    @FindBy(className = "paj-click2")
    private WebElement yellowBellyHover;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToPajacyk() {
        driver.get("https://www.pajacyk.pl/#index");
    }

    public void clickOnBelly() {
        mouseOver(greenBellyBefore);
        click(yellowBellyHover);
    }

}

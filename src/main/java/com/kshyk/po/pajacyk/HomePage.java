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

    public HomePage(final WebDriver driver) {
        super(driver);
    }

    public final void goToPajacyk() {
        getDriver().get("https://www.pajacyk.pl/#index");
    }

    public final void clickOnBelly() {
        mouseOver(greenBellyBefore);
        click(yellowBellyHover);
    }

}

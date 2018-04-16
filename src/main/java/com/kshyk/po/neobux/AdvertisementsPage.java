package com.kshyk.po.neobux;

import com.kshyk.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdvertisementsPage extends BasePage {

    @FindBy(id = "sInf0")
    private WebElement resetInfoBar;
    @FindBy(css = ".adfu,.adf")
    private List<WebElement> activeAds;

    public AdvertisementsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return resetInfoBar.isDisplayed();
    }

    public List<WebElement> getActiveAds() {
        return activeAds;
    }

    public <T> void clickOnActiveAdvertisement(T activeAd) {
        sleep(1500);
        mouseOverAndClick(activeAd);
    }

    public void clickOnRedDot(By dotElem) {
        sleep(1000);
        clickFirstVisibleElement(dotElem);
        driver.getWindowHandles().forEach(handle -> driver.switchTo().window(handle));
    }
}

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
    @FindBy(id = "ap_h")
    private WebElement adChances;

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

    public int getChances() {
        return Integer.parseInt(adChances.getAttribute("textContent"));
    }

    public boolean isNullChancesVisible() {
        return driver.findElements(By.id("ap_hct0")).size() != 0;
    }

    public void clickOnChances() {
        sleep(1500);
        mouseOverAndClick(adChances);
        driver.getWindowHandles().forEach(handle -> driver.switchTo().window(handle));
    }
}

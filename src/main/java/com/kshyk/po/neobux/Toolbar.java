package com.kshyk.po.neobux;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Toolbar extends BasePage {

    @FindBy(id = "navAds")
    private WebElement viewAdvertisements;

    public Toolbar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AdvertisementsPage goToViewAdvertisements() {
        mouseOverAndClick(this.viewAdvertisements);
        return PageFactory.initElements(driver, AdvertisementsPage.class);
    }
}

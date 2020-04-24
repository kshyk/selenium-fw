package com.kshyk.pageobjects.teamandpersonal.bars;

import com.codeborne.selenide.SelenideElement;
import com.kshyk.enums.teamandpersonal.SocialMedia;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public class NavigationBar {
    private final SelenideElement topkaMail = $(".topka-mail a");

    public String getTelephoneText() {
        return $(className("topka-tel")).getText();
    }

    public String getMailHrefValue() {
        return topkaMail.getAttribute("href");
    }

    public String getMailText() {
        return topkaMail.getText();
    }

    public void clickOnSocialMediaButton(SocialMedia socialMedia) {
        socialMedia.getSelenideElement()
                .click();
    }
}
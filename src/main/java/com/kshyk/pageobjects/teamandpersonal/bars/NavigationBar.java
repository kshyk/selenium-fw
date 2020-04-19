package com.kshyk.pageobjects.teamandpersonal.bars;

import com.codeborne.selenide.SelenideElement;
import com.kshyk.enums.teamandpersonal.SocialMedia;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public class NavigationBar {
    private final SelenideElement topkaMail = $(".topka-mail a");

    public void telephoneShouldHaveText(String phone) {
        $(className("topka-tel")).shouldHave(text(phone));
    }

    public NavigationBar mailShouldHaveHrefValue(String value) {
        topkaMail.shouldHave(attribute("href", value));
        return this;
    }

    public void mailShouldHaveText(String mail) {
        topkaMail.shouldHave(text(mail));
    }

    public void clickOnSocialMediaButton(SocialMedia socialMedia) {
        socialMedia.getSelenideElement()
                .click();
    }
}
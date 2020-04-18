package com.kshyk.po.teamandpersonal.bars;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public class NavigationBar {
    public void clickOnFacebookButton() {
        $(className("topka-facebook")).click();
    }

    public void clickOnGooglePlusButton() {
        $(className("topka-google")).click();
    }

    public void clickOnYouTubeButton() {
        $(className("topka-youtube")).click();
    }

    public void clickOnLinkedInButton() {
        $(className("topka-linkedin")).click();
    }

    public void clickOnPinterestButton() {
        $(className("topka-pinterest")).click();
    }

    public void clickOnInstagramButton() {
        $(className("topka-instagram")).click();
    }

    public void clickOnTwitterButton() {
        $(className("topka-twitter")).click();
    }
}

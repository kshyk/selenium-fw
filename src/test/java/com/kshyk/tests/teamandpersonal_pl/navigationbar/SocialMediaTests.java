package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.codeborne.selenide.Selenide;
import com.kshyk.po.teamandpersonal.bars.NavigationBar;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.BDDAssertions.then;

class SocialMediaTests extends TestCase {
    private NavigationBar navigationBar;

    @BeforeAll
    public void openHomePage() {
        navigationBar = open("https://teamandpersonal.pl/", NavigationBar.class);
    }

    @AfterEach
    public void goBack() {
        Selenide.back();
    }

    @Test
    public void checkFacebook() {
        navigationBar.clickOnFacebookButton();
        then(url()).contains("https://www.facebook.com/TeamAndPersonal/?ref=bookmarks");
    }

    @Test
    public void checkGooglePlus() {
        navigationBar.clickOnGooglePlusButton();
        then(url()).contains("https://plus.google.com/+TeamandpersonalPl");
    }

    @Test
    public void checkYouTube() {
        navigationBar.clickOnYouTubeButton();
        then(url()).contains("https://www.youtube.com/channel/UCealDsXd2QtuW_on0wjSqtw");
    }

    @Test
    public void checkLinkedIn() {
        navigationBar.clickOnLinkedInButton();
        then(url()).contains("https://www.linkedin.com/company/teamandpersonal/");
    }

    @Test
    public void checkInstagram() {
        navigationBar.clickOnInstagramButton();
        then(url()).contains("https://www.instagram.com/teamandpersonal/");
    }

    @Test
    public void checkPinterest() {
        navigationBar.clickOnPinterestButton();
        then(url()).startsWith("https://www.pinterest.com/teampersonal/");
    }

    @Test
    public void checkTwitter() {
        navigationBar.clickOnTwitterButton();
        then(url()).contains("https://twitter.com/TeamAndPersonal");
    }
}
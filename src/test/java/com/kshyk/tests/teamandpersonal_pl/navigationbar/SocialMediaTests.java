package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.codeborne.selenide.Selenide;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.BDDAssertions.then;

class SocialMediaTests extends TestCase {
    @BeforeAll
    void openHomePage() {
        open("https://teamandpersonal.pl/");
    }

    @AfterEach
    void goBack() {
        Selenide.back();
    }

    @Test
    public void checkFacebook() {
        $(".topka-facebook").click();
        then(url()).contains("https://www.facebook.com/TeamAndPersonal/?ref=bookmarks");
    }

    @Test
    public void checkGooglePlus() {
        $(".topka-google").click();
        then(url()).contains("https://plus.google.com/+TeamandpersonalPl");
    }

    @Test
    public void checkYouTube() {
        $(".topka-youtube").click();
        then(url()).contains("https://www.youtube.com/channel/UCealDsXd2QtuW_on0wjSqtw");
    }

    @Test
    public void checkLinkedIn() {
        $(".topka-linkedin").click();
        then(url()).contains("https://www.linkedin.com/company/teamandpersonal/");
    }

    @Test
    public void checkInstagram() {
        $(".topka-instagram").click();
        then(url()).contains("https://www.instagram.com/teamandpersonal/");
    }

    @Test
    public void checkPinterest() {
        $(".topka-pinterest").click();
        then(url()).contains(
                "https://www.pinterest.com/teampersonal/?sender=602708500040250336&invite_code=6877095e58a1439aa50df3831a86b83f");
    }

    @Test
    public void checkTwitter() {
        $(".topka-twitter").click();
        then(url()).contains("https://twitter.com/TeamAndPersonal");
    }
}
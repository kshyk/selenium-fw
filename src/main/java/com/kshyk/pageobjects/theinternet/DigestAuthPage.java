package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

public class DigestAuthPage implements PageContent {
    public static DigestAuthPage open() {
        return Selenide.open("https://admin:admin@the-internet.herokuapp.com/digest_auth", DigestAuthPage.class);
    }
}

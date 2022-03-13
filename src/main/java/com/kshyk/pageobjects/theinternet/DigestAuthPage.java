package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

public class DigestAuthPage implements PageContent {
    public static DigestAuthPage open() {
        Selenide.open("http://admin:admin@the-internet.herokuapp.com/digest_auth");
        return new DigestAuthPage();
    }
}

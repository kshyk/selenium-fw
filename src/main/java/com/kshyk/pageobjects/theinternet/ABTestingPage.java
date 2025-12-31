package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

public class ABTestingPage implements PageContent {
    public static ABTestingPage open() {
        return Selenide.open("/abtest", ABTestingPage.class);
    }
}

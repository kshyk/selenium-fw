package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.BasicAuthCredentials;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.AuthenticationType.BASIC;
import static com.kshyk.common.EnvHolder.ADMIN_PASSWORD;

public class BasicAuthPage implements PageContent {
    public static BasicAuthPage open() {
        var credentials = new BasicAuthCredentials("admin", ADMIN_PASSWORD);
        Selenide.open("/basic_auth", BASIC, credentials);
        return new BasicAuthPage();
    }
}

package com.kshyk.pageobjects.teamandpersonal;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement goUpButton = $("a.go-top");

    public static HomePage open() {
        Selenide.open("/");
        return new HomePage();
    }

    public void scrollToTop() {
        goUpButton.hover().click();
    }
}

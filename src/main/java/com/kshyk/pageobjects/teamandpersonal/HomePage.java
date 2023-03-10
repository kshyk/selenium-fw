package com.kshyk.pageobjects.teamandpersonal;

import com.codeborne.selenide.Selenide;

public class HomePage {
    public static HomePage open() {
        Selenide.open("/");
        return new HomePage();
    }
}

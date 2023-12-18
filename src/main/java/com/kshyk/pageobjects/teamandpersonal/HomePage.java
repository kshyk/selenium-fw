package com.kshyk.pageobjects.teamandpersonal;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public HomePage() {
        Selenide.open("/");
        $(".home").shouldBe(visible);
    }
}

package com.kshyk.pageobjects.okruszek;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement bread = $(".click-crumb");
    private final SelenideElement thanks = $("section#thanks");

    public static HomePage open() {
        Selenide.open("http://www.okruszek.org.pl");
        return new HomePage();
    }

    public void donate() {
        bread.hover().click();
        thanks.should(appear);
    }

    public boolean isDonated() {
        return thanks.is(visible);
    }
}

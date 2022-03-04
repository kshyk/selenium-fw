package com.kshyk.pageobjects.pajacyk;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement bellyButton = $(".pajacyk__clickbox");
    private final SelenideElement thanks = $(".pajacyk__thankyou");

    public static HomePage open() {
        Selenide.open("https://www.pajacyk.pl/#index");
        return new HomePage();
    }

    public void donate() {
        bellyButton.hover().click();
        thanks.should(appear);
    }

    public boolean isDonated() {
        return thanks.is(visible);
    }
}

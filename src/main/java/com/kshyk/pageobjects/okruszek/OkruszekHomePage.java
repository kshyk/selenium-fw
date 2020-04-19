package com.kshyk.pageobjects.okruszek;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OkruszekHomePage {
    public OkruszekHomePage clickOnBread() {
        $(".click-crumb").click();
        return this;
    }

    public SelenideElement thanks() {
        return $(byText("DZIĘKUJEMY!"));
    }
}
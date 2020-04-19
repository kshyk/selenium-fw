package com.kshyk.pageobjects.pajacyk;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ThanksPage {
    public SelenideElement thanks() {
        return $(byText("dziękujemy :)"));
    }
}
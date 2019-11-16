package com.kshyk.po.pajacyk;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PajacykHomePage {
    public ThanksPage clickOnBelly() {
        $(".paj-click").click();
        return page(ThanksPage.class);
    }
}
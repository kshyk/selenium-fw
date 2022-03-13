package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$$;

public class HoversPage implements PageContent {
    public static HoversPage open() {
        Selenide.open("/hovers");
        return new HoversPage();
    }

    public HoversPage mouseOverImageByIndex(int index) {
        $$(".figure img").get(index).hover();
        return this;
    }
}

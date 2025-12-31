package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$$;

public class HoversPage implements PageContent {
    public static HoversPage open() {
        return Selenide.open("/hovers", HoversPage.class);
    }

    public HoversPage mouseOverImageByIndex(int index) {
        $$(".figure img").get(index).hover();
        return this;
    }
}

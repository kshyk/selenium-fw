package com.kshyk.pageobjects.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$$;

public class HoversPage {
    public void mouseOverImageByIndex(int index) {
        $$(".figure img").get(index).hover();
    }
}
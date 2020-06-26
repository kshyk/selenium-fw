package com.kshyk.helpers.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$$;

public class HoversPageHelper {
    private HoversPageHelper() {
    }

    public static void mouseOverImageByIndex(int index) {
        $$(".figure img").get(index).hover();
    }
}
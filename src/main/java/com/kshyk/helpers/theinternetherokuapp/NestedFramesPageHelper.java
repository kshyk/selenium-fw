package com.kshyk.helpers.theinternetherokuapp;

import com.kshyk.enums.theinternetherokuapp.Frame;

import static com.codeborne.selenide.Selenide.switchTo;

public class NestedFramesPageHelper {
    private NestedFramesPageHelper() {
    }

    public static void switchToFrame(Frame frame) {
        switchTo().frame(frame.getPosition());
    }

    public static void switchToInnerFrame(Frame frame) {
        switchTo().innerFrame(frame.getPosition());
    }
}

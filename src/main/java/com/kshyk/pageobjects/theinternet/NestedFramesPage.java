package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;
import com.kshyk.enums.theinternetherokuapp.Frame;

import static com.codeborne.selenide.Selenide.switchTo;

public class NestedFramesPage implements PageContent {
    public static NestedFramesPage open() {
        return Selenide.open("/nested_frames", NestedFramesPage.class);
    }

    public void switchToFrame(Frame frame) {
        switchTo().frame(frame.getPosition());
    }

    public void switchToInnerFrame(Frame frame) {
        switchTo().innerFrame(frame.getPosition());
    }
}

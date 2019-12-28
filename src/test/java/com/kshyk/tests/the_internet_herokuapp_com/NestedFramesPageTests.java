package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;

class NestedFramesPageTests extends TestCase {
    @BeforeAll
    void openNestedFramesPage() {
        open("http://the-internet.herokuapp.com/nested_frames");
    }

    @Test
    public void isBottomFrameLocatedProperly() {
        switchTo().frame("frame-bottom");
        $(By.tagName("body")).shouldHave(text("BOTTOM"));
    }

    @Test
    public void isLeftFrameLocatedProperly() {
        switchTo().innerFrame("frame-top");
        switchTo().frame("frame-left");
        $(By.tagName("body")).shouldHave(text("LEFT"));
    }

    @Test
    public void isMiddleFrameLocatedProperly() {
        switchTo().innerFrame("frame-top");
        switchTo().frame("frame-middle");
        $(By.tagName("body")).shouldHave(text("MIDDLE"));
    }

    @Test
    public void isRightFrameLocatedProperly() {
        switchTo().innerFrame("frame-top");
        switchTo().frame("frame-right");
        $(By.tagName("body")).shouldHave(text("RIGHT"));
    }

    @BeforeEach
    void switchToDefaultContent() {
        driver().switchTo().defaultContent();
    }
}
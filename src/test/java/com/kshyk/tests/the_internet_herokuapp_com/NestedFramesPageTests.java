package com.kshyk.tests.the_internet_herokuapp_com;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.kshyk.tests.base.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NestedFramesPageTests extends TestCase {
    private SelenideElement body = $(By.tagName("body"));

    @BeforeClass
    public final void isNestedFramesPageLoaded() {
        open("http://the-internet.herokuapp.com/nested_frames");
        $(By.tagName("frameset")).should(appear);
    }

    @AfterMethod
    public final void switchToDefaultContent() {
        WebDriverRunner.driver().switchTo().defaultContent();
    }

    @Test
    public final void isBottomFrameLocatedProperly() {
        WebDriverRunner.driver().switchTo().frame("frame-bottom");
        body.shouldHave(text("BOTTOM"));
    }

    @Test
    public final void isLeftFrameLocatedProperly() {
        WebDriverRunner.driver().switchTo().frame("frame-top");
        WebDriverRunner.driver().switchTo().frame("frame-left");
        body.shouldHave(text("LEFT"));
    }

    @Test
    public final void isMiddleFrameLocatedProperly() {
        WebDriverRunner.driver().switchTo().frame("frame-top");
        WebDriverRunner.driver().switchTo().frame("frame-middle");
        body.shouldHave(text("MIDDLE"));
    }

    @Test
    public final void isRightFrameLocatedProperly() {
        WebDriverRunner.driver().switchTo().frame("frame-top");
        WebDriverRunner.driver().switchTo().frame("frame-right");
        body.shouldHave(text("RIGHT"));
    }
}
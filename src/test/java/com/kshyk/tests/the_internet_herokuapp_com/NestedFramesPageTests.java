package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.NestedFramesPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NestedFramesPageTests extends BaseTest {

    private final By body = By.tagName("body");

    private NestedFramesPage nestedFramesPO;

    @Test
    public final void isNestedFramesPageLoaded() {
        getPage().getInstance(HomePage.class).goToHerokuapp();
        getPage().getInstance(HomePage.class).goToNestedFrames();
        nestedFramesPO = getPage().getInstance(NestedFramesPage.class);
        assertTrue(nestedFramesPO.isOpen(), NestedFramesPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(priority = 1)
    public final void isBottomFrameLocatedProperly() {
        nestedFramesPO.switchToBottom();
        getWait().until(ExpectedConditions.textToBe(body, "BOTTOM"));
    }

    @Test(priority = 1)
    public final void isLeftFrameLocatedProperly() {
        nestedFramesPO.switchToLeft();
        getWait().until(ExpectedConditions.textToBe(body, "LEFT"));
    }

    @Test(priority = 1)
    public final void isMiddleFrameLocatedProperly() {
        nestedFramesPO.switchToMiddle();
        getWait().until(ExpectedConditions.textToBe(body, "MIDDLE"));
    }

    @Test(priority = 1)
    public final void isRightFrameLocatedProperly() {
        nestedFramesPO.switchToRight();
        getWait().until(ExpectedConditions.textToBe(body, "RIGHT"));
    }

}
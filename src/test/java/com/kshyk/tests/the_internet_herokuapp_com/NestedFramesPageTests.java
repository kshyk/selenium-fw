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
    public void isNestedFramesPageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        page.getInstance(HomePage.class).goToNestedFrames();
        nestedFramesPO = page.getInstance(NestedFramesPage.class);
        assertTrue(nestedFramesPO.isOpen(), NestedFramesPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "isNestedFramesPageLoaded")
    public void isBottomFrameLocatedProperly() {
        nestedFramesPO.switchToBottom();
        wait.until(ExpectedConditions.textToBe(body, "BOTTOM"));
    }

    @Test(dependsOnMethods = "isNestedFramesPageLoaded")
    public void isLeftFrameLocatedProperly() {
        nestedFramesPO.switchToLeft();
        wait.until(ExpectedConditions.textToBe(body, "LEFT"));
    }

    @Test(dependsOnMethods = "isNestedFramesPageLoaded")
    public void isMiddleFrameLocatedProperly() {
        nestedFramesPO.switchToMiddle();
        wait.until(ExpectedConditions.textToBe(body, "MIDDLE"));
    }

    @Test(dependsOnMethods = "isNestedFramesPageLoaded")
    public void isRightFrameLocatedProperly() {
        nestedFramesPO.switchToRight();
        wait.until(ExpectedConditions.textToBe(body, "RIGHT"));
    }

}
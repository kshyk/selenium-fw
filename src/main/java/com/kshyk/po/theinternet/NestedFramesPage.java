package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {

    @FindBy(tagName = "frameset")
    private WebElement frameset;

    @FindBy(name = "frame-top")
    private WebElement topFrame;

    @FindBy(name = "frame-left")
    private WebElement leftFrame;

    @FindBy(name = "frame-middle")
    private WebElement middleFrame;

    @FindBy(name = "frame-right")
    private WebElement rightFrame;

    @FindBy(name = "frame-bottom")
    private WebElement bottomFrame;

    public NestedFramesPage(final WebDriver driver) {
        super(driver);
    }

    public final boolean isOpen() {
        return this.frameset.isDisplayed();
    }

    public final void switchToLeft() {
        backToRoot().switchToTop();
        getDriver().switchTo().frame(leftFrame);
    }

    public final void switchToMiddle() {
        backToRoot().switchToTop();
        getDriver().switchTo().frame(middleFrame);
    }

    public final void switchToRight() {
        backToRoot().switchToTop();
        getDriver().switchTo().frame(rightFrame);
    }

    private void switchToTop() {
        getDriver().switchTo().frame(topFrame);
    }

    public final void switchToBottom() {
        backToRoot();
        getDriver().switchTo().frame(bottomFrame);
    }

    private NestedFramesPage backToRoot() {
        getDriver().switchTo().defaultContent();
        return this;
    }

}
package com.kshyk.tests.the_internet_herokuapp_com;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.Iterables;
import com.kshyk.tests.base.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MultipleWindowsPageTests extends TestCase {
    @Test
    public void isMultipleWindowsPageLoaded() {
        open("http://the-internet.herokuapp.com/windows");
        $(byText("Opening a new window")).should(appear);
    }

    @Test(dependsOnMethods = "isMultipleWindowsPageLoaded")
    public void isNewWindowOpened() {
        $(byLinkText("Click Here")).click();
        this.switchToLastTab();
        $(By.tagName("h3")).shouldHave(text("New Window"));
    }

    @Test(dependsOnMethods = "isNewWindowOpened")
    public void isDefaultContentPresentAfterNewWindowClose() {
        this.switchToFirstTab();
        $(byText("Opening a new window")).should(appear);
    }

    private void switchToFirstTab() {
        var driver = WebDriverRunner.getWebDriver();
        driver.close();
        driver.switchTo().window(Iterables.getFirst(driver.getWindowHandles(), ""));
    }

    private void switchToLastTab() {
        var driver = WebDriverRunner.getWebDriver();
        driver.switchTo().window(Iterables.getLast(driver.getWindowHandles()));
    }
}
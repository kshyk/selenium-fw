package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.google.common.collect.Iterables.getLast;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MultipleWindowsPageTests extends TestCase {
    @BeforeAll
    public void openMultipleWindowsPage() {
        open("http://the-internet.herokuapp.com/windows");
    }

    @Test
    @Order(1)
    public void isNewWindowOpened() {
        $(byLinkText("Click Here")).click();
        switchTo().window(getLast(getWebDriver().getWindowHandles()));
        $(By.tagName("h3")).shouldHave(text("New Window"));
    }

    @Test
    @Order(2)
    public void isDefaultContentPresentAfterNewWindowClose() {
        getWebDriver().close();
        switchTo().window(0);
        $(byText("Opening a new window")).should(appear);
    }
}
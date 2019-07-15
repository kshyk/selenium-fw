package com.kshyk.tests.the_internet_herokuapp_com;

import com.codeborne.selenide.WebDriverRunner;
import com.kshyk.tests.base.TestCase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TinyMCEPageTests extends TestCase {
    @Test
    public final void isTinyMCEPageLoaded() {
        open("http://the-internet.herokuapp.com/tinymce");
        $(byText("An iFrame containing the TinyMCE WYSIWYG Editor")).should(appear);
    }

    @Test(dependsOnMethods = "isTinyMCEPageLoaded")
    public final void clearAndSetNewContent() {
        this.setContent("");
        this.setContent(LocalDateTime.now().toString());
    }

    private void setContent(final String content) {
        final var jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        jse.executeScript("tinymce.activeEditor.setContent(arguments[0]);", content);
    }
}
package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.TinyMCEPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.assertTrue;

public class TinyMCEPageTests extends BaseTest {

    @Test
    public final void isTinyMCEPageLoaded() {
        getPage().getInstance(HomePage.class).goToHerokuapp();
        getPage().getInstance(HomePage.class).goToTinyMCE();
        assertTrue(getPage().getInstance(TinyMCEPage.class).isOpen(),
                TinyMCEPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "isTinyMCEPageLoaded")
    public final void clearAndSetNewContent() {
        this.setContent("");
        this.setContent(LocalDateTime.now().toString());
    }

    private void setContent(final String content) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("tinymce.activeEditor.setContent(arguments[0]);", content);
    }
}
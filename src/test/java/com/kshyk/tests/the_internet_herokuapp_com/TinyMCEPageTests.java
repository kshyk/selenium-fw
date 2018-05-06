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
    public void isTinyMCEPageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        page.getInstance(HomePage.class).goToTinyMCE();
        assertTrue(page.getInstance(TinyMCEPage.class).isOpen(),
                TinyMCEPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "isTinyMCEPageLoaded")
    public void clearAndSetNewContent() {
        this.setContent("");
        this.setContent(LocalDateTime.now().toString());
    }

    private void setContent(final String content) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("tinymce.activeEditor.setContent(arguments[0]);", content);
    }
}
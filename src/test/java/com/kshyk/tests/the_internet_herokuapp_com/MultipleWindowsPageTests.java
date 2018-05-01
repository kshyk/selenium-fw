package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.MultipleWindowsPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.testng.Assert.assertTrue;

public class MultipleWindowsPageTests extends BaseTest {

    private MultipleWindowsPage multipleWindowsPO;

    @Test
    public void isMultipleWindowsPageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        page.getInstance(HomePage.class).goToMultipleWindows();
        multipleWindowsPO = page.getInstance(MultipleWindowsPage.class);
        assertTrue(multipleWindowsPO.isOpen(), MultipleWindowsPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "isMultipleWindowsPageLoaded")
    public void isNewWindowOpened() {
        multipleWindowsPO.openNewWindow();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        multipleWindowsPO.switchToLastTab();
        final Pattern resultText = Pattern.compile("New Window");
        wait.until(ExpectedConditions.textMatches(By.tagName("body"), resultText));
    }

    @Test(dependsOnMethods = "isNewWindowOpened")
    public void isDefaultContentPresentAfterNewWindowClose() {
        final Stream<String> stream = page.getDriver().getWindowHandles().stream();
        final Optional<String> rootTab = stream.findFirst();
        page.getDriver().close();
        rootTab.ifPresent(tab -> page.getDriver().switchTo().window(tab));
        assertTrue(multipleWindowsPO.isOpen(), MultipleWindowsPage.class.getSimpleName() + " is not loaded.");
    }

}
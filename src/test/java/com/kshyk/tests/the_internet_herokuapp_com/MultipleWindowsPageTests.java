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
        getPage().getInstance(HomePage.class).goToHerokuapp();
        getPage().getInstance(HomePage.class).goToMultipleWindows();
        multipleWindowsPO = getPage().getInstance(MultipleWindowsPage.class);
        assertTrue(multipleWindowsPO.isOpen(), MultipleWindowsPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "isMultipleWindowsPageLoaded")
    public void isNewWindowOpened() {
        multipleWindowsPO.openNewWindow();
        getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
        multipleWindowsPO.switchToLastTab();
        final Pattern resultText = Pattern.compile("New Window");
        getWait().until(ExpectedConditions.textMatches(By.tagName("body"), resultText));
    }

    @Test(dependsOnMethods = "isNewWindowOpened")
    public void isDefaultContentPresentAfterNewWindowClose() {
        final Stream<String> stream = getPage().getDriver().getWindowHandles().stream();
        final Optional<String> rootTab = stream.findFirst();
        getPage().getDriver().close();
        rootTab.ifPresent(tab -> getPage().getDriver().switchTo().window(tab));
        assertTrue(multipleWindowsPO.isOpen(), MultipleWindowsPage.class.getSimpleName() + " is not loaded.");
    }

}
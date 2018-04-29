package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.JavaScriptAlertsPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptAlertsPageTests extends BaseTest {

    private JavaScriptAlertsPage jsAlertsPO;

    @Test
    public void checkPage_IsJavaScriptAlertsPageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        page.getInstance(HomePage.class).goToJSAlerts();
        this.jsAlertsPO = page.getInstance(JavaScriptAlertsPage.class);
        assertTrue(this.jsAlertsPO.isOpen(), JavaScriptAlertsPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "checkPage_IsJavaScriptAlertsPageLoaded")
    public void checkPage_IsSimpleAlertAppeared() {
        this.jsAlertsPO.alert();
        this.driver.switchTo().alert().accept();
        final String expected = "You successfuly clicked an alert";
        assertEquals(this.jsAlertsPO.getResult(), expected);
    }

    @Test(dependsOnMethods = "checkPage_IsSimpleAlertAppeared")
    public void checkPage_IsConfirmAlertCancelled() {
        this.jsAlertsPO.confirm();
        this.driver.switchTo().alert().dismiss();
        final String expected = "You clicked: Cancel";
        assertEquals(this.jsAlertsPO.getResult(), expected);
    }

    @Test(dependsOnMethods = "checkPage_IsConfirmAlertCancelled")
    public void checkPage_IsPromptAlertSaveText() {
        this.jsAlertsPO.prompt();
        final String value = "I'm typing in here!";
        final Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
        final String expected = "You entered: " + value;
        assertEquals(this.jsAlertsPO.getResult(), expected);
    }

}
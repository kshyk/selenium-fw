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
    public void isJavaScriptAlertsPageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        page.getInstance(HomePage.class).goToJSAlerts();
        this.jsAlertsPO = page.getInstance(JavaScriptAlertsPage.class);
        assertTrue(this.jsAlertsPO.isOpen(), JavaScriptAlertsPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "isJavaScriptAlertsPageLoaded")
    public void isSimpleAlertAppeared() {
        this.jsAlertsPO.alert();
        this.driver.switchTo().alert().accept();
        final String expected = "You successfuly clicked an alert";
        assertEquals(this.jsAlertsPO.getResult(), expected);
    }

    @Test(dependsOnMethods = "isSimpleAlertAppeared")
    public void isConfirmAlertCancelled() {
        this.jsAlertsPO.confirm();
        this.driver.switchTo().alert().dismiss();
        final String expected = "You clicked: Cancel";
        assertEquals(this.jsAlertsPO.getResult(), expected);
    }

    @Test(dependsOnMethods = "isConfirmAlertCancelled")
    public void isPromptAlertSaveText() {
        this.jsAlertsPO.prompt();
        final String value = "I'm typing in here!";
        final Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
        final String expected = "You entered: " + value;
        assertEquals(this.jsAlertsPO.getResult(), expected);
    }

}
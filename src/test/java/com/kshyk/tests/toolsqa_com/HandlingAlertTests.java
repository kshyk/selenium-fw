package com.kshyk.tests.toolsqa_com;

import com.kshyk.po.toolsqa.DemoAlertsPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class HandlingAlertTests extends BaseTest {

    @Test
    public void handleAlert_ConfirmSimpleAlertTest() {
        DemoAlertsPage demoAlertsPO = page.getInstance(DemoAlertsPage.class);
        demoAlertsPO.goToDemoAlerts();
        demoAlertsPO.pressSimpleAlertButton();
        driver.switchTo().alert().accept();
    }

    @Test
    public void handleAlert_DismissAlertBoxTest() {
        page.getInstance(DemoAlertsPage.class).pressConfirmAlertButton();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void handleAlert_ConfirmAlertBoxTest() {
        page.getInstance(DemoAlertsPage.class).pressConfirmAlertButton();
        driver.switchTo().alert().accept();
    }

    @Test
    public void handleAlert_DismissPromptAlertBoxTest() {
        page.getInstance(DemoAlertsPage.class).pressPromptAlertButton();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void handleAlert_ConfirmWithTextPromptAlertBoxTest() {
        page.getInstance(DemoAlertsPage.class).pressPromptAlertButton();
        final Alert alert = driver.switchTo().alert();
        alert.sendKeys("lubię to!");
        alert.accept();
    }
}
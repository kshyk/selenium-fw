package com.kshyk.tests.toolsqa_com;

import com.kshyk.po.toolsqa.DemoAlertsPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class HandlingAlertTests extends BaseTest {

    @Test
    public final void confirmSimpleAlertTest() {
        DemoAlertsPage demoAlertsPO = getPage().getInstance(DemoAlertsPage.class);
        demoAlertsPO.goToDemoAlerts();
        demoAlertsPO.pressSimpleAlertButton();
        getDriver().switchTo().alert().accept();
    }

    @Test
    public final void dismissAlertBoxTest() {
        getPage().getInstance(DemoAlertsPage.class).pressConfirmAlertButton();
        getDriver().switchTo().alert().dismiss();
    }

    @Test
    public final void dismissPromptAlertBoxTest() {
        getPage().getInstance(DemoAlertsPage.class).pressPromptAlertButton();
        getDriver().switchTo().alert().dismiss();
    }

    @Test
    public final void confirmWithTextPromptAlertBoxTest() {
        getPage().getInstance(DemoAlertsPage.class).pressPromptAlertButton();
        final Alert alert = getDriver().switchTo().alert();
        alert.sendKeys("I like it!");
        alert.accept();
    }
}
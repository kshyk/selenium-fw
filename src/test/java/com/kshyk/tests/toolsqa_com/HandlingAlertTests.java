package com.kshyk.tests.toolsqa_com;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.kshyk.po.toolsqa.DemoAlertsPage;
import com.kshyk.tests.base.BaseTest;

public class HandlingAlertTests extends BaseTest {
	
	@Test
	public final void confirmSimpleAlertTest() {
		final DemoAlertsPage demoAlertsPO = this.getPage().getInstance(DemoAlertsPage.class);
		demoAlertsPO.goToDemoAlerts();
		demoAlertsPO.pressSimpleAlertButton();
		this.getDriver().switchTo().alert().accept();
	}
	
	@Test
	public final void dismissAlertBoxTest() {
		this.getPage().getInstance(DemoAlertsPage.class).pressConfirmAlertButton();
		this.getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	public final void dismissPromptAlertBoxTest() {
		this.getPage().getInstance(DemoAlertsPage.class).pressPromptAlertButton();
		this.getDriver().switchTo().alert().dismiss();
	}
	
	@Test
	public final void confirmWithTextPromptAlertBoxTest() {
		this.getPage().getInstance(DemoAlertsPage.class).pressPromptAlertButton();
		final Alert alert = this.getDriver().switchTo().alert();
		alert.sendKeys("I like it!");
		alert.accept();
	}
}
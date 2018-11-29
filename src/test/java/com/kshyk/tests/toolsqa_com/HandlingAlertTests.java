package com.kshyk.tests.toolsqa_com;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.kshyk.po.toolsqa.DemoAlertsPage;
import com.kshyk.tests.base.BaseTest;

class HandlingAlertTests extends BaseTest {
	
	private DemoAlertsPage demoAlertsPO;
	
	@BeforeGroups(groups = "alerts are coming")
	private void initAlertPage() {
		this.demoAlertsPO = this.getPage().getInstance(DemoAlertsPage.class);
	}
	
	@Test(groups = "alerts are coming")
	public final void confirmSimpleAlertTest() {
		this.demoAlertsPO.goToDemoAlerts();
		this.demoAlertsPO.pressSimpleAlertButton();
		this.getDriver().switchTo().alert().accept();
	}
	
	@Test(groups = "alerts are coming")
	public final void dismissAlertBoxTest() {
		this.demoAlertsPO.pressConfirmAlertButton();
		this.getDriver().switchTo().alert().dismiss();
	}
	
	@Test(groups = "alerts are coming")
	public final void dismissPromptAlertBoxTest() {
		this.demoAlertsPO.pressPromptAlertButton();
		this.getDriver().switchTo().alert().dismiss();
	}
}
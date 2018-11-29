package com.kshyk.tests.okruszek_org_pl;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.okruszek.HomePage;
import com.kshyk.tests.base.BaseTest;

class CrumbClickTests extends BaseTest {
	
	@Test
	public final void clickOnCrumbTest() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToOkruszek().clickOnCrumb();
		this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='DZIĘKUJEMY!']")));
	}
	
}
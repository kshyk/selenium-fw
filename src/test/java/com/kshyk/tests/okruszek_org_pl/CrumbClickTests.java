package com.kshyk.tests.okruszek_org_pl;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.okruszek.HomePage;
import com.kshyk.tests.base.BaseTest;

public class CrumbClickTests extends BaseTest {
	
	@Test
	public final void clickOnCrumbTest() {
		this.getPage().getInstance(HomePage.class).goToOkruszek();
		this.getPage().getInstance(HomePage.class).clickOnCrumb();
		this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='DZIĘKUJEMY!']")));
	}
	
}
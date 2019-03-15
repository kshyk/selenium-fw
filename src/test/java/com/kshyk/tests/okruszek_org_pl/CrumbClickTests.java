package com.kshyk.tests.okruszek_org_pl;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.kshyk.po.okruszek.HomePage;
import com.kshyk.tests.base.BaseTest;

class CrumbClickTests extends BaseTest {
	
	@Test
	public final void clickOnCrumbTest() {
		final var homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToOkruszek()
				.clickOnCrumb();
		final var expectedLocator = By.xpath("//*[text()='DZIĘKUJEMY!']");
		this.getWait().until(visibilityOfElementLocated(expectedLocator));
	}
	
}
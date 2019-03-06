package com.kshyk.tests.pajacyk_pl;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.pajacyk.HomePage;
import com.kshyk.tests.base.BaseTest;

class BellyClickTests extends BaseTest {
	
	@Test
	public final void clickOnBellyTest() {
		final var homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToPajacyk()
				.clickOnBelly();
		final var expectedLocator = By.xpath("//*[text()='dziękujemy :)']");
		this.getWait().until(ExpectedConditions.visibilityOfElementLocated(expectedLocator));
	}
	
}
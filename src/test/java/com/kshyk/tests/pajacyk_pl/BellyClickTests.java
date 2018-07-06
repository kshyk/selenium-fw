package com.kshyk.tests.pajacyk_pl;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.pajacyk.HomePage;
import com.kshyk.tests.base.BaseTest;

public class BellyClickTests extends BaseTest {
	
	@Test
	public final void clickOnBellyTest() {
		this.getPage().getInstance(HomePage.class).goToPajacyk();
		this.getPage().getInstance(HomePage.class).clickOnBelly();
		this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='dziękujemy :)']")));
	}
	
}
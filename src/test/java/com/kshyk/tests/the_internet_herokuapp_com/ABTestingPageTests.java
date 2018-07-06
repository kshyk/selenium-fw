package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.kshyk.po.theinternet.ABTestPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

public class ABTestingPageTests extends BaseTest {
	
	@Test
	public final void isABTestPageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		this.getPage().getInstance(HomePage.class).goToABTest();
		assertTrue(this.getPage().getInstance(ABTestPage.class).isOpen(),
				ABTestPage.class.getSimpleName() + " is not loaded.");
	}
	
}
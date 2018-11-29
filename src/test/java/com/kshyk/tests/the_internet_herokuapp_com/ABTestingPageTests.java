package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import org.testng.annotations.Test;

import com.kshyk.po.theinternet.ABTestPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

class ABTestingPageTests extends BaseTest {
	
	@Test
	public final void isABTestPageLoaded() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToHerokuapp().goToABTest();
		final ABTestPage abTestPage = this.getPage().getInstance(ABTestPage.class);
		then(abTestPage.isOpen())
				.as(ABTestPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
}
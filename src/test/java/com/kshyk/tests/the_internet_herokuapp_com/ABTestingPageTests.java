package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import org.testng.annotations.Test;

import com.kshyk.po.theinternet.AbTestPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

class ABTestingPageTests extends BaseTest {
	
	@Test
	public final void isABTestPageLoaded() {
		this.getPage()
				.getInstance(HomePage.class)
				.goToHerokuapp()
				.goToABTest();
		then(this.getPage()
				.getInstance(AbTestPage.class)
				.isOpen())
				.as(AbTestPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
}
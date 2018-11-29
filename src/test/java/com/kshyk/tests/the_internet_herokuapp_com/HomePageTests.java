package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

class HomePageTests extends BaseTest {
	
	@Test
	public final void isHomePageLoaded() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		then(homePage.goToHerokuapp().isOpen())
				.as(HomePage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
}
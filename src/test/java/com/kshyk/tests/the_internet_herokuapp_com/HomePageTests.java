package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

public class HomePageTests extends BaseTest {
	
	@Test
	public final void isHomePageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		assertTrue(this.getPage().getInstance(HomePage.class).isOpen(),
				HomePage.class.getSimpleName() + " is not loaded.");
	}
	
}
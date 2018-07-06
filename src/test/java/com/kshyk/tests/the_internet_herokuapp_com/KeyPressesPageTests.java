package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.KeyPressesPage;
import com.kshyk.tests.base.BaseTest;

public class KeyPressesPageTests extends BaseTest {
	
	@Test
	public final void isKeyPressesPageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		this.getPage().getInstance(HomePage.class).goToKeyPresses();
		assertTrue(this.getPage().getInstance(KeyPressesPage.class).isOpen(),
				KeyPressesPage.class.getSimpleName() + " is not loaded.");
	}
	
	@Test(dependsOnMethods = "isKeyPressesPageLoaded")
	public final void isKeyProperlyEntered() {
		final Keys control = Keys.CONTROL;
		final String expected = "You entered: " + control.name();
		final String actual = this.getPage().getInstance(KeyPressesPage.class).pressKeyAndGetResult(control);
		assertEquals(actual, expected);
	}
	
}
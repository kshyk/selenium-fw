package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.KeyPressesPage;
import com.kshyk.tests.base.BaseTest;

class KeyPressesPageTests extends BaseTest {
	
	private final Keys control = Keys.CONTROL;
	private KeyPressesPage keyPressesPage;
	
	@Test
	public final void isKeyPressesPageLoaded() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToHerokuapp().goToKeyPresses();
		this.keyPressesPage = this.getPage().getInstance(KeyPressesPage.class);
		then(this.keyPressesPage.isOpen())
				.as(KeyPressesPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnMethods = "isKeyPressesPageLoaded")
	public final void isKeyProperlyEntered() {
		final String expected = "You entered: " + this.control.name();
		final String actual = this.keyPressesPage.pressKeyAndGetResult(this.control);
		then(actual).isEqualTo(expected);
	}
	
}
package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.JavaScriptAlertsPage;
import com.kshyk.tests.base.BaseTest;

class JavaScriptAlertsPageTests extends BaseTest {
	
	private JavaScriptAlertsPage jsAlertsPO;
	
	@Test
	public final void isJavaScriptAlertsPageLoaded() {
		this.getPage()
				.getInstance(HomePage.class)
				.goToHerokuapp()
				.goToJSAlerts();
		this.jsAlertsPO = this.getPage().getInstance(JavaScriptAlertsPage.class);
		assertTrue(this.jsAlertsPO.isOpen(), JavaScriptAlertsPage.class.getSimpleName() + " is not loaded.");
	}
	
	@Test(dependsOnMethods = "isJavaScriptAlertsPageLoaded")
	public final void isSimpleAlertAppeared() {
		this.jsAlertsPO.alert();
		this.getDriver().switchTo().alert().accept();
		final var expected = "You successfuly clicked an alert";
		then(this.jsAlertsPO.getResult()).isEqualTo(expected);
	}
	
	@Test(dependsOnMethods = "isSimpleAlertAppeared")
	public final void isConfirmAlertCancelled() {
		this.jsAlertsPO.confirm();
		this.getDriver().switchTo().alert().dismiss();
		final var expected = "You clicked: Cancel";
		then(this.jsAlertsPO.getResult()).isEqualTo(expected);
	}
	
	@Test(dependsOnMethods = "isConfirmAlertCancelled")
	public final void isPromptAlertSaveText() {
		this.jsAlertsPO.prompt();
		final var value = "I'm typing in here!";
		final var alert = this.getDriver().switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
		final var expected = "You entered: " + value;
		then(this.jsAlertsPO.getResult()).isEqualTo(expected);
	}
	
}
package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.textMatches;

import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.kshyk.po.theinternet.ForgotPasswordPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

class ForgotPasswordPageTests extends BaseTest {
	
	private ForgotPasswordPage forgotPasswordPage;
	
	@Test(groups = "open forgot password")
	public final void isForgotPasswordPageLoaded() {
		this.getPage()
				.getInstance(HomePage.class)
				.goToHerokuapp()
				.goToForgotPassword();
		this.forgotPasswordPage = this.getPage().getInstance(ForgotPasswordPage.class);
		then(this.forgotPasswordPage.isOpen())
				.as(ForgotPasswordPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnGroups = "open forgot password")
	public final void isPasswordReset() {
		final var email = "test@example.com";
		final var successMessage = Pattern.compile("Your e-mail's been sent!");
		this.forgotPasswordPage.resetPassword(email);
		this.getWait().until(textMatches(tagName("body"), successMessage));
	}
	
}
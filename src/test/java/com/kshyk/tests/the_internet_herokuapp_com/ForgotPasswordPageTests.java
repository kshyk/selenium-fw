package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.ForgotPasswordPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

class ForgotPasswordPageTests extends BaseTest {
	
	private ForgotPasswordPage forgotPasswordPage;
	
	@Test(groups = "open forgot password")
	public final void isForgotPasswordPageLoaded() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToHerokuapp().goToForgotPassword();
		this.forgotPasswordPage = this.getPage().getInstance(ForgotPasswordPage.class);
		then(this.forgotPasswordPage.isOpen())
				.as(ForgotPasswordPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnGroups = "open forgot password")
	public final void isPasswordReset() {
		final String email = "test@example.com";
		final Pattern successMessage = Pattern.compile("Your e-mail's been sent!");
		this.forgotPasswordPage.resetPassword(email);
		this.getWait().until(ExpectedConditions.textMatches(By.tagName("body"), successMessage));
	}
	
}
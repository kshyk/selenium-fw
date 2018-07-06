package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertTrue;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.ForgotPasswordPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

public class ForgotPasswordPageTests extends BaseTest {
	
	@Test
	public final void isForgotPasswordPageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		this.getPage().getInstance(HomePage.class).goToForgotPassword();
		assertTrue(this.getPage().getInstance(ForgotPasswordPage.class).isOpen(),
				ForgotPasswordPage.class.getSimpleName() + " is not loaded.");
	}
	
	@Test(dependsOnMethods = "isForgotPasswordPageLoaded")
	public final void isPasswordReset() {
		final String email = "test@example.com";
		final Pattern successMessage = Pattern.compile("Your e-mail's been sent!");
		this.getPage().getInstance(ForgotPasswordPage.class).resetPassword(email);
		this.getWait().until(ExpectedConditions.textMatches(By.tagName("body"), successMessage));
	}
	
}

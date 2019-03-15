package com.kshyk.tests.n11_com;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.kshyk.po.n11.HomePage;
import com.kshyk.po.n11.LoginPage;
import com.kshyk.tests.base.BaseTest;

class LoginTests extends BaseTest {
	
	private LoginPage loginPage;
	
	@BeforeGroups(groups = "check logon variants")
	private void goToLoginPage() {
		this.getPage()
				.getInstance(HomePage.class)
				.open()
				.clickOnSignInButton();
		this.loginPage = this.getPage().getInstance(LoginPage.class);
	}
	
	@Test(groups = "check logon variants")
	public final void invalidUserNameInvalidPassword() {
		this.loginPage.loginToN11("onur@swtestacademy.com", "11223344");
		this.getWait().until(visibilityOfElementLocated(By.xpath("//*[text()='E-posta adresiniz veya şifreniz hatalı']")));
		this.loginPage.verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
	}
	
	@Test(groups = "check logon variants")
	public final void emptyUserEmptyPassword() {
		this.loginPage.loginToN11("", "");
		this.getWait().until(visibilityOfElementLocated(By.xpath("//*[text()='Lütfen e-posta adresinizi girin.']")));
		this.loginPage.verifyLoginUserName("Lütfen e-posta adresinizi girin.");
		this.getWait().until(visibilityOfElementLocated(By.xpath("//*[text()='Bu alanın doldurulması zorunludur.']")));
		this.loginPage.verifyLoginPassword("Bu alanın doldurulması zorunludur.");
	}
	
}
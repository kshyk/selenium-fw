package com.kshyk.tests.n11_com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.n11.HomePage;
import com.kshyk.po.n11.LoginPage;
import com.kshyk.tests.base.BaseTest;

public class LoginTests extends BaseTest {
	
	@Test
	public final void invalidUserNameInvalidPassword() {
		this.getPage().getInstance(HomePage.class).goToN11();
		this.getPage().getInstance(HomePage.class).goToLoginPage().loginToN11("onur@swtestacademy.com", "11223344");
		this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='E-posta adresiniz veya şifreniz hatalı']")));
		this.getPage().getInstance(LoginPage.class).verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
	}
	
	@Test
	public final void emptyUserEmptyPassword() {
		this.getPage().getInstance(HomePage.class).goToN11();
		this.getPage().getInstance(HomePage.class).goToLoginPage().loginToN11("", "");
		this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Lütfen e-posta adresinizi girin.']")));
		this.getPage().getInstance(LoginPage.class).verifyLoginUserName("Lütfen e-posta adresinizi girin.");
		this.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Bu alanın doldurulması zorunludur.']")));
		this.getPage().getInstance(LoginPage.class).verifyLoginPassword("Bu alanın doldurulması zorunludur.");
	}
	
}
package com.kshyk.tests;

import com.kshyk.core.HomePage;
import com.kshyk.core.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test()
    public void invalidLoginTest_InvalidUserNameInvalidPassword() {
        page.getInstance(HomePage.class).goToN11();
        page.getInstance(HomePage.class).goToLoginPage().loginToN11("onur@swtestacademy.com", "11223344");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='E-posta adresiniz veya şifreniz hatalı']")));
        page.getInstance(LoginPage.class).verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test(priority = 1)
    public void invalidLoginTest_EmptyUserEmptyPassword() {
        page.getInstance(HomePage.class).goToN11();
        page.getInstance(HomePage.class).goToLoginPage().loginToN11("", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Lütfen e-posta adresinizi girin.']")));
        page.getInstance(LoginPage.class).verifyLoginUserName("Lütfen e-posta adresinizi girin.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Bu alanın doldurulması zorunludur.']")));
        page.getInstance(LoginPage.class).verifyLoginPassword("Bu alanın doldurulması zorunludur.");
    }

}
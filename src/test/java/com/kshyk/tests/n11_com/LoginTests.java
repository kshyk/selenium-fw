package com.kshyk.tests.n11_com;

import com.kshyk.po.n11.HomePage;
import com.kshyk.po.n11.LoginPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public final void invalidUserNameInvalidPassword() {
        getPage().getInstance(HomePage.class).goToN11();
        getPage().getInstance(HomePage.class).goToLoginPage().loginToN11("onur@swtestacademy.com", "11223344");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='E-posta adresiniz veya şifreniz hatalı']")));
        getPage().getInstance(LoginPage.class).verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test
    public final void emptyUserEmptyPassword() {
        getPage().getInstance(HomePage.class).goToN11();
        getPage().getInstance(HomePage.class).goToLoginPage().loginToN11("", "");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Lütfen e-posta adresinizi girin.']")));
        getPage().getInstance(LoginPage.class).verifyLoginUserName("Lütfen e-posta adresinizi girin.");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Bu alanın doldurulması zorunludur.']")));
        getPage().getInstance(LoginPage.class).verifyLoginPassword("Bu alanın doldurulması zorunludur.");
    }

}
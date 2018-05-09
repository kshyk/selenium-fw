package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.ForgotPasswordPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class ForgotPasswordPageTests extends BaseTest {

    @Test
    public final void isForgotPasswordPageLoaded() {
        getPage().getInstance(HomePage.class).goToHerokuapp();
        getPage().getInstance(HomePage.class).goToForgotPassword();
        assertTrue(getPage().getInstance(ForgotPasswordPage.class).isOpen(),
                ForgotPasswordPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "isForgotPasswordPageLoaded")
    public final void isPasswordReset() {
        final String email = "test@example.com";
        final Pattern successMessage = Pattern.compile("Your e-mail's been sent!");
        getPage().getInstance(ForgotPasswordPage.class).resetPassword(email);
        getWait().until(ExpectedConditions.textMatches(By.tagName("body"), successMessage));
    }

}

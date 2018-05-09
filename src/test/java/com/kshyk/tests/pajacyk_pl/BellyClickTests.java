package com.kshyk.tests.pajacyk_pl;

import com.kshyk.po.pajacyk.HomePage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class BellyClickTests extends BaseTest {

    @Test
    public final void clickOnBellyTest() {
        getPage().getInstance(HomePage.class).goToPajacyk();
        getPage().getInstance(HomePage.class).clickOnBelly();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='dziękujemy :)']")));
    }

}
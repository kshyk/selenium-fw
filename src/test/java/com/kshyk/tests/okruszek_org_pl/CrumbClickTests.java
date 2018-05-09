package com.kshyk.tests.okruszek_org_pl;

import com.kshyk.po.okruszek.HomePage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CrumbClickTests extends BaseTest {

    @Test
    public final void clickOnCrumbTest() {
        getPage().getInstance(HomePage.class).goToOkruszek();
        getPage().getInstance(HomePage.class).clickOnCrumb();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='DZIĘKUJEMY!']")));
    }

}
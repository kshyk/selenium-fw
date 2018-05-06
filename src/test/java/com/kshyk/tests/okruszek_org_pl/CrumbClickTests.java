package com.kshyk.tests.okruszek_org_pl;

import com.kshyk.po.okruszek.HomePage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CrumbClickTests extends BaseTest {

    @Test
    public void clickOnCrumbTest() {
        page.getInstance(HomePage.class).goToOkruszek();
        page.getInstance(HomePage.class).clickOnCrumb();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='DZIĘKUJEMY!']")));
    }

}
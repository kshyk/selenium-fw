package com.kshyk.tests.neobux_com;

import com.kshyk.po.neobux.LoginPage;
import com.kshyk.po.neobux.SummaryPage;
import com.kshyk.po.neobux.Toolbar;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EarnMoneyTests extends BaseTest {

    @Test()
    public void earnMoney_SuccessfulLogonProcess() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        loginPage.goToMemberLogin();
        loginPage.fillCredentials();
        if (loginPage.isCaptchaVisible()) {
            wait.until(bool -> loginPage.getCaptcha().getAttribute("value").length() == 5);
        }
        loginPage.send();
        wait.until(ExpectedConditions.visibilityOf(page.getInstance(SummaryPage.class).getClicksChart()));
    }

    @Test(dependsOnMethods = "earnMoney_SuccessfulLogonProcess")
    public void earnMoney_ClickOnEveryActiveAdvertisement() {
        page.getInstance(Toolbar.class).goToViewAdvertisements();
    }

    @Test(dependsOnMethods = "earnMoney_ClickOnEveryActiveAdvertisement")
    public void earnMoney_RunLotteryAfterAds() {

    }

}

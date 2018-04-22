package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.ABTestPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ABTestingTests extends BaseTest {

    @Test
    public void checkPage_IsABTestPageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        page.getInstance(HomePage.class).goToABTest();
        assertTrue(page.getInstance(ABTestPage.class).isOpen(),
                ABTestPage.class.getSimpleName() + " is not loaded.");
    }

}
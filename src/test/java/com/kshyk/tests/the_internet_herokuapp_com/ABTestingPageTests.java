package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.ABTestPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ABTestingPageTests extends BaseTest {

    @Test
    public final void isABTestPageLoaded() {
        getPage().getInstance(HomePage.class).goToHerokuapp();
        getPage().getInstance(HomePage.class).goToABTest();
        assertTrue(getPage().getInstance(ABTestPage.class).isOpen(),
                ABTestPage.class.getSimpleName() + " is not loaded.");
    }

}
package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTests extends BaseTest {

    @Test
    public void checkPage_IsHomePageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        assertTrue(page.getInstance(HomePage.class).isOpen(),
                HomePage.class.getSimpleName() + " is not loaded.");
    }

}
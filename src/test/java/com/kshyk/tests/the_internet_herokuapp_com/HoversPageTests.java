package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.HoversPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversPageTests extends BaseTest {

    @Test
    public void checkPage_IsHoversPageLoaded() {
        page.getInstance(HomePage.class).goToHerokuapp();
        page.getInstance(HomePage.class).goToHovers();
        assertTrue(page.getInstance(HoversPage.class).isOpen(),
                HoversPage.class.getSimpleName() + " is not loaded.");
    }

    @Test(dependsOnMethods = "checkPage_IsHoversPageLoaded")
    public void checkPage_IsAdditionalInfoPresentAfterHoverOverImage() {
        final List<String> users = List.of("user1", "user2", "user3");
        final HoversPage hoversPO = page.getInstance(HoversPage.class);
        final List<WebElement> avatars = hoversPO.getAvatars();

        hoversPO.mouseOverAvatar(avatars.get(0));
        assertEquals(hoversPO.getVisibleName(), "name: " + users.get(0));

        hoversPO.mouseOverAvatar(avatars.get(2));
        assertEquals(hoversPO.getVisibleName(), "name: " + users.get(2));

        hoversPO.mouseOverAvatar(avatars.get(1));
        assertEquals(hoversPO.getVisibleName(), "name: " + users.get(1));
    }

}
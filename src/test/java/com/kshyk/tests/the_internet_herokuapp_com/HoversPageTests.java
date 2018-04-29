package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.HoversPage;
import com.kshyk.tests.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

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
        final Map<Integer, String> map = Map.of(0, "user1", 2, "user3", 1, "user2");
        final HoversPage hoversPO = page.getInstance(HoversPage.class);
        final List<WebElement> avatars = hoversPO.getAvatars();
        map.forEach((index, name) -> {
            hoversPO.mouseOverAvatar(avatars.get(index));
            assertEquals(hoversPO.getVisibleName(), "name: " + name);
        });
    }

}
package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.HoversPage;
import com.kshyk.tests.base.BaseTest;

public class HoversPageTests extends BaseTest {
	
	@Test
	public void isHoversPageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		this.getPage().getInstance(HomePage.class).goToHovers();
		assertTrue(this.getPage().getInstance(HoversPage.class).isOpen(),
				HoversPage.class.getSimpleName() + " is not loaded.");
	}
	
	@Test(dependsOnMethods = "isHoversPageLoaded")
	public void isAdditionalInfoPresentAfterHoverOverImage() {
		final Map<Integer, String> map = Map.of(0, "user1", 2, "user3", 1, "user2");
		final HoversPage hoversPO = this.getPage().getInstance(HoversPage.class);
		final List<WebElement> avatars = hoversPO.getAvatars();
		map.forEach((index, name) -> {
			hoversPO.mouseOverAvatar(avatars.get(index));
			assertEquals(hoversPO.getVisibleName(), "name: " + name);
		});
	}
	
}
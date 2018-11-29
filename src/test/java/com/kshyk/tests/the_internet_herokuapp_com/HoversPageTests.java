package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.HoversPage;
import com.kshyk.tests.base.BaseTest;

class HoversPageTests extends BaseTest {
	
	private HoversPage hoversPage;
	
	@Test
	public void isHoversPageLoaded() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToHerokuapp().goToHovers();
		this.hoversPage = this.getPage().getInstance(HoversPage.class);
		then(this.hoversPage.isOpen())
				.as(HoversPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnMethods = "isHoversPageLoaded")
	public void isAdditionalInfoPresentAfterHoverOverImage() {
		final Map<Integer, String> map = Map.of(0, "user1", 2, "user3", 1, "user2");
		this.hoversPage = this.getPage().getInstance(HoversPage.class);
		final List<WebElement> avatars = this.hoversPage.getAvatars();
		map.forEach((index, name) -> {
			this.hoversPage.mouseOverAvatar(avatars.get(index));
			then(this.hoversPage.getVisibleName()).isEqualTo("name: " + name);
		});
	}
	
}
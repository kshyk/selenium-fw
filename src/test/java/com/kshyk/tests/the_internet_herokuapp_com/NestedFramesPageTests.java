package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.NestedFramesPage;
import com.kshyk.tests.base.BaseTest;

class NestedFramesPageTests extends BaseTest {
	
	private final By body = By.tagName("body");
	
	private NestedFramesPage nestedFramesPO;
	
	@Test(groups = "init test")
	public final void isNestedFramesPageLoaded() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToHerokuapp().goToNestedFrames();
		this.nestedFramesPO = this.getPage().getInstance(NestedFramesPage.class);
		then(this.nestedFramesPO.isOpen())
				.as(NestedFramesPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnGroups = "init test")
	public final void isBottomFrameLocatedProperly() {
		this.nestedFramesPO.switchToBottom();
		this.getWait().until(ExpectedConditions.textToBe(this.body, "BOTTOM"));
	}
	
	@Test(dependsOnGroups = "init test")
	public final void isLeftFrameLocatedProperly() {
		this.nestedFramesPO.switchToLeft();
		this.getWait().until(ExpectedConditions.textToBe(this.body, "LEFT"));
	}
	
	@Test(dependsOnGroups = "init test")
	public final void isMiddleFrameLocatedProperly() {
		this.nestedFramesPO.switchToMiddle();
		this.getWait().until(ExpectedConditions.textToBe(this.body, "MIDDLE"));
	}
	
	@Test(dependsOnGroups = "init test")
	public final void isRightFrameLocatedProperly() {
		this.nestedFramesPO.switchToRight();
		this.getWait().until(ExpectedConditions.textToBe(this.body, "RIGHT"));
	}
	
}
package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.NestedFramesPage;
import com.kshyk.tests.base.BaseTest;

class NestedFramesPageTests extends BaseTest {
	
	private final By body = By.tagName("body");
	
	private NestedFramesPage nestedFramesPO;
	
	@Test(groups = "init test")
	public final void isNestedFramesPageLoaded() {
		this.getPage()
				.getInstance(HomePage.class)
				.goToHerokuapp()
				.goToNestedFrames();
		this.nestedFramesPO = this.getPage().getInstance(NestedFramesPage.class);
		then(this.nestedFramesPO.isOpen())
				.as(NestedFramesPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnGroups = "init test")
	public final void isBottomFrameLocatedProperly() {
		this.nestedFramesPO.switchToBottom();
		this.getWait().until(textToBe(this.body, "BOTTOM"));
	}
	
	@Test(dependsOnGroups = "init test")
	public final void isLeftFrameLocatedProperly() {
		this.nestedFramesPO.switchToLeft();
		this.getWait().until(textToBe(this.body, "LEFT"));
	}
	
	@Test(dependsOnGroups = "init test")
	public final void isMiddleFrameLocatedProperly() {
		this.nestedFramesPO.switchToMiddle();
		this.getWait().until(textToBe(this.body, "MIDDLE"));
	}
	
	@Test(dependsOnGroups = "init test")
	public final void isRightFrameLocatedProperly() {
		this.nestedFramesPO.switchToRight();
		this.getWait().until(textToBe(this.body, "RIGHT"));
	}
	
}
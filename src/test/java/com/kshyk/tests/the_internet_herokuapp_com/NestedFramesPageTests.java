package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.NestedFramesPage;
import com.kshyk.tests.base.BaseTest;

public class NestedFramesPageTests extends BaseTest {
	
	private final By body = By.tagName("body");
	
	private NestedFramesPage nestedFramesPO;
	
	@Test
	public final void isNestedFramesPageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		this.getPage().getInstance(HomePage.class).goToNestedFrames();
		this.nestedFramesPO = this.getPage().getInstance(NestedFramesPage.class);
		assertTrue(this.nestedFramesPO.isOpen(), NestedFramesPage.class.getSimpleName() + " is not loaded.");
	}
	
	@Test(priority = 1)
	public final void isBottomFrameLocatedProperly() {
		this.nestedFramesPO.switchToBottom();
		this.getWait().until(ExpectedConditions.textToBe(this.body, "BOTTOM"));
	}
	
	@Test(priority = 1)
	public final void isLeftFrameLocatedProperly() {
		this.nestedFramesPO.switchToLeft();
		this.getWait().until(ExpectedConditions.textToBe(this.body, "LEFT"));
	}
	
	@Test(priority = 1)
	public final void isMiddleFrameLocatedProperly() {
		this.nestedFramesPO.switchToMiddle();
		this.getWait().until(ExpectedConditions.textToBe(this.body, "MIDDLE"));
	}
	
	@Test(priority = 1)
	public final void isRightFrameLocatedProperly() {
		this.nestedFramesPO.switchToRight();
		this.getWait().until(ExpectedConditions.textToBe(this.body, "RIGHT"));
	}
	
}
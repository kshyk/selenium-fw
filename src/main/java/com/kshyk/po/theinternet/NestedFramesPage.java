package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class NestedFramesPage extends AbstractPage {
	
	@FindBy(tagName = "frameset")
	private WebElement frameset;
	@FindBy(name = "frame-top")
	private WebElement topFrame;
	@FindBy(name = "frame-left")
	private WebElement leftFrame;
	@FindBy(name = "frame-middle")
	private WebElement middleFrame;
	@FindBy(name = "frame-right")
	private WebElement rightFrame;
	@FindBy(name = "frame-bottom")
	private WebElement bottomFrame;
	
	public NestedFramesPage(final WebDriver driver) {
		super(driver);
	}
	
	public final boolean isOpen() {
		return this.frameset.isDisplayed();
	}
	
	public final void switchToLeft() {
		this.backToRoot().switchToTop();
		this.driver.switchTo().frame(this.leftFrame);
	}
	
	public final void switchToMiddle() {
		this.backToRoot().switchToTop();
		this.driver.switchTo().frame(this.middleFrame);
	}
	
	public final void switchToRight() {
		this.backToRoot().switchToTop();
		this.driver.switchTo().frame(this.rightFrame);
	}
	
	private void switchToTop() {
		this.driver.switchTo().frame(this.topFrame);
	}
	
	public final void switchToBottom() {
		this.backToRoot();
		this.driver.switchTo().frame(this.bottomFrame);
	}
	
	private NestedFramesPage backToRoot() {
		this.driver.switchTo().defaultContent();
		return this;
	}
}

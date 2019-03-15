package com.kshyk.po.theinternet;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class KeyPressesPage extends AbstractPage {
	
	@FindBy(xpath = "//*[text()='Key Presses']")
	private WebElement title;
	@FindBy(id = "result")
	private WebElement result;
	
	public KeyPressesPage(final WebDriver driver) {
		super(driver);
	}
	
	public final boolean isOpen() {
		return this.title.isDisplayed();
	}
	
	public final String pressKeyAndGetResult(final Keys key) {
		super.basePage.pressKey(key);
		return this.getResult();
	}
	
	private String getResult() {
		return this.result.getText();
	}
	
}

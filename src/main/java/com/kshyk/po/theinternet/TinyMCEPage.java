package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class TinyMCEPage {
	
	private final BasePage basePage;
	@FindBy(xpath = "//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")
	private WebElement title;
	
	public TinyMCEPage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
	}
	
	public final boolean isOpen() {
		return this.basePage.isElementDisplayed(this.title);
	}
}

package com.kshyk.po;

import org.openqa.selenium.WebDriver;

import com.kshyk.core.BasePage;

public abstract class AbstractPage {
	
	protected final WebDriver driver;
	protected final BasePage basePage;
	
	protected AbstractPage(final WebDriver driver) {
		this.driver = driver;
		this.basePage = new BasePage(this.driver);
	}
	
}

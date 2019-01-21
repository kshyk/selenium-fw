package com.kshyk.po.teamandpersonal;

import org.openqa.selenium.WebDriver;

import com.kshyk.core.BasePage;

public class HomePage {
	
	private final BasePage basePage;
	private final WebDriver driver;
	
	public HomePage(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
	}
	
	public final HomePage open() {
		this.driver.get("https://teamandpersonal.pl/");
		return this;
	}
}

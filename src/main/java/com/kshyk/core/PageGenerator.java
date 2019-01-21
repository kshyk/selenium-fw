package com.kshyk.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestException;

public class PageGenerator {
	
	private final WebDriver driver;
	private final Logger logger = LoggerFactory.getLogger(PageGenerator.class);
	
	public PageGenerator(final WebDriver webDriver) {
		this.driver = webDriver;
	}
	
	public final <TPage> TPage getInstance(final Class<TPage> pageClass) {
		try {
			return PageFactory.initElements(this.driver, pageClass);
		}
		catch (final Exception ex) {
			throw new TestException("Cannot initialize requested page with its elements.", ex);
		}
	}
	
	public final WebDriver getDriver() {
		return this.driver;
	}
	
	public final Logger getLogger() {
		return this.logger;
	}
}

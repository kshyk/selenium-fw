package com.kshyk.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageGenerator {
	
	private final WebDriver driver;
	private final Logger logger = LoggerFactory.getLogger(PageGenerator.class);
	
	public PageGenerator(final WebDriver wd) {
		this.driver = wd;
	}
	
	public final <TPage extends BasePage> TPage getInstance(final Class<TPage> pageClass) {
		try {
			return PageFactory.initElements(this.driver, pageClass);
		}
		catch (final Exception ex) {
			this.logger.error("Cannot initialize requested page with its elements.", ex);
			throw ex;
		}
	}
	
	public final WebDriver getDriver() {
		return this.driver;
	}
	
	protected final Logger getLogger() {
		return this.logger;
	}
}

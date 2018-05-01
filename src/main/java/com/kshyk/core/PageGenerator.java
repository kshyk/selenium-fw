package com.kshyk.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageGenerator {

    private final WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(PageGenerator.class);

    public PageGenerator(WebDriver driver) {
        this.driver = driver;
    }

    public final <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver, pageClass);
        } catch (final Exception ex) {
            logger.error("Cannot initialize requested page with its elements.", ex);
            throw ex;
        }
    }

    public final WebDriver getDriver() {
        return driver;
    }

    public final Logger getLogger() {
        return logger;
    }
}

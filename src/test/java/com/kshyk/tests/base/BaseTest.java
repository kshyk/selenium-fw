package com.kshyk.tests.base;

import com.kshyk.core.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Objects;

public abstract class BaseTest {

    private static final int NORMAL_TIMEOUT = 15;
    private WebDriverWait wait;
    private PageGenerator page;
    private WebDriver driver;

    @BeforeClass
    public final void setup() {
        driver = this.getChromeDriver();
        wait = new WebDriverWait(driver, NORMAL_TIMEOUT);
        driver.manage().window().maximize();
        page = new PageGenerator(driver);
    }

    @AfterClass
    public final void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private ChromeDriver getChromeDriver() {
        final File chrome = new File(Objects.requireNonNull(BaseTest.class.getClassLoader().getResource("drivers/chromedriver")).getFile());
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        return new ChromeDriver(chromeOptions);
    }

    protected final WebDriverWait getWait() {
        return wait;
    }

    protected final PageGenerator getPage() {
        return page;
    }

    protected final WebDriver getDriver() {
        return driver;
    }
}
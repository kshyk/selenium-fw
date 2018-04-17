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

public class BaseTest {

    protected WebDriverWait wait;
    protected PageGenerator page;
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = this.getChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        page = new PageGenerator(driver);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private ChromeDriver getChromeDriver() {
        final File chrome = new File(Objects.requireNonNull(BaseTest.class.getClassLoader().getResource("chromedriver")).getFile());
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        return new ChromeDriver(chromeOptions);
    }
}
package com.kshyk.tests;

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

    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;

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
        final File chrome = new File(Objects.requireNonNull(BaseTest.class.getClassLoader().getResource("chromedriver.exe")).getFile());
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        return new ChromeDriver(chromeOptions);
    }
}
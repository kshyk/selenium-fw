package com.kshyk.tests;

import com.kshyk.core.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kshyk\\IdeaProjects\\selenium-kshyk\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-extensions");
        driver = new ChromeDriver();
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
}
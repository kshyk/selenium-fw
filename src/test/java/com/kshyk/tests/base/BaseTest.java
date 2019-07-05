package com.kshyk.tests.base;

import com.kshyk.core.PageGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Deprecated(since = "05.07.2019", forRemoval = true)
public abstract class BaseTest
{

    private static final int NORMAL_TIMEOUT = 15;
    private WebDriverWait wait;
    private PageGenerator page;
    private WebDriver driver;

    @BeforeClass
    public final void setup()
    {
        this.driver = this.getChromeDriver();
        this.wait = new WebDriverWait(this.driver, NORMAL_TIMEOUT);
        this.driver.manage().window().maximize();
        this.page = new PageGenerator(this.driver);
    }

    @AfterClass
    public final void teardown()
    {
        if (this.driver != null)
            this.driver.quit();
    }

    private ChromeDriver getChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        final var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        return new ChromeDriver(chromeOptions);
    }

    protected final WebDriverWait getWait()
    {
        return this.wait;
    }

    public final PageGenerator getPage()
    {
        return this.page;
    }

    protected final WebDriver getDriver()
    {
        return this.driver;
    }
}

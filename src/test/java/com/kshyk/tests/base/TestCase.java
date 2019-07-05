package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public abstract class TestCase
{
    @BeforeClass
    public final void setup()
    {
        Configuration.timeout = 5000;
        Configuration.headless = true;
        Configuration.startMaximized = true;
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
}

package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TestCase {
    @BeforeAll
    protected void setup() {
        Configuration.timeout = 5000;
        var key = System.getProperty("TESTINGBOT_KEY");
        System.out.println("key=" + key);
        var secret = System.getProperty("TESTINGBOT_SECRET");
        System.out.println("secret=" + secret);
        System.getenv().forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        Configuration.remote = "https://" + key + ":" + secret + "@hub.testingbot.com/wd/hub";
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }
}
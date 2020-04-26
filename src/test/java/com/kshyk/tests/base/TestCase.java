package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TestCase {
    @BeforeAll
    protected void setup() {
        Configuration.timeout = 5000;
        var key = System.getenv("TESTINGBOT_KEY");
        var secret = System.getenv("TESTINGBOT_SECRET");
        Configuration.remote = "https://" + key + ":" + secret + "@hub.testingbot.com/wd/hub";
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }
}
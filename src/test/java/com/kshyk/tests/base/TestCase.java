package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TestCase {
    @BeforeAll
    public void setup() {
        Configuration.timeout = 5000;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }
}
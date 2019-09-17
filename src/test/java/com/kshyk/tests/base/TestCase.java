package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public abstract class TestCase {
    @BeforeClass
    public void setup() {
        Configuration.timeout = 5000;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }
}
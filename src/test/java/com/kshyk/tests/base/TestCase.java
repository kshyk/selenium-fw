package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public abstract class TestCase {
    @BeforeClass
    public void setup() {
        Configuration.timeout = 5000;
        Configuration.headless = true;
        Configuration.startMaximized = true;
    }
}

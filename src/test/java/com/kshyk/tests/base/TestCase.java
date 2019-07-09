package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public abstract class TestCase {
    @BeforeClass
    public final void setup() {
        Configuration.timeout = 5000;
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }
}

package com.kshyk.tests.base;

import com.codeborne.selenide.Configuration;
import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@VisibleForTesting
public abstract class TestCase {
    @BeforeAll
    public void setup() {
        Configuration.timeout = 5000;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.headless = true;
        Configuration.startMaximized = true;
    }
}
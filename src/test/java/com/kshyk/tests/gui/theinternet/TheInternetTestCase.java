package com.kshyk.tests.gui.theinternet;

import com.codeborne.selenide.Configuration;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;

public abstract class TheInternetTestCase extends TestCase {
    @BeforeAll
    protected void configuration() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }
}

package com.kshyk.tests.gui.teamandpersonal;

import com.codeborne.selenide.Configuration;
import com.kshyk.pageobjects.teamandpersonal.HomePage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class TNPTestCase extends TestCase {
    protected HomePage homePage;

    @BeforeAll
    protected void configuration() {
        Configuration.baseUrl = "https://teamandpersonal.pl";
    }

    @BeforeEach
    protected void openHomePage() {
        homePage = new HomePage();
    }
}

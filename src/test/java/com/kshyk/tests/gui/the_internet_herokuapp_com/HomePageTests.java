package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomePageTests extends TestCase {
    @BeforeAll
    void openHomePage() {
        open("http://the-internet.herokuapp.com/");
    }

    @Test
    void isHomePageLoaded() {
        assertTrue(PageContent.getContentText().contains("Welcome to the-internet"));
    }
}

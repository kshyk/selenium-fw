package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.kshyk.pageobjects.teamandpersonal.bars.NavigationBar;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactTests extends TestCase {
    private NavigationBar navigationBar;

    @BeforeAll
    public void openHomePage() {
        navigationBar = open("https://teamandpersonal.pl/", NavigationBar.class);
    }

    @Test
    @Order(0)
    public void checkTelephone() {
        navigationBar.telephoneShouldHaveText("+48 660 22 77 22");
    }

    @Test
    @Order(0)
    public void checkMail() {
        navigationBar.mailShouldHaveHrefValue("mailto:biuro@teamandpersonal.pl")
                .mailShouldHaveText("biuro [at] teamandpersonal.pl");
    }
}
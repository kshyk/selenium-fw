package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class ContactTests extends TestCase {
    @BeforeAll
    public void openHomePage() {
        open("https://teamandpersonal.pl/");
    }

    @Test
    public void checkTelephone() {
        $(".topka-tel").shouldHave(text("+48 660 22 77 22"));
    }

    @Test
    public void checkMailRefAttribute() {
        $(".topka-mail a").shouldHave(attribute("href", "mailto:biuro@teamandpersonal.pl"));
    }

    @Test
    public void checkMail() {
        $(".topka-mail a").shouldHave(text("biuro [at] teamandpersonal.pl"));
    }
}
package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactTests extends TestCase
{
    @BeforeClass
    public void openHomePage()
    {
        open("https://teamandpersonal.pl/");
    }

    @Test
    public final void checkTelephone()
    {
        $(".topka-tel").shouldHave(text("+48 660 22 77 22"));
    }

    @Test
    public final void checkMailRefAttribute()
    {
        $(".topka-mail a").shouldHave(attribute("href", "mailto:biuro@teamandpersonal.pl"));
    }

    @Test
    public final void checkMail()
    {
        $(".topka-mail a").shouldHave(text("biuro [at] teamandpersonal.pl"));
    }
}

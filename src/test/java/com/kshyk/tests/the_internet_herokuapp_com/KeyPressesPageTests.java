package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class KeyPressesPageTests extends TestCase
{
    @Test
    public final void isKeyPressesPageLoaded()
    {
        open("http://the-internet.herokuapp.com/key_presses");
        $(byText("Key Presses")).shouldBe(visible);
    }

    @Test(dependsOnMethods = "isKeyPressesPageLoaded")
    public final void isKeyProperlyEntered()
    {
        $("body").pressTab();
        $("#result").shouldHave(text("You entered: " + Keys.TAB.name()));
    }
}
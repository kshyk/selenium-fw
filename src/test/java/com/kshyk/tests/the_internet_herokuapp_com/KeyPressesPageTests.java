package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class KeyPressesPageTests extends TestCase {
    @Test
    void isKeyProperlyEntered() {
        open("http://the-internet.herokuapp.com/key_presses");
        $("body").pressTab();
        $("#result").shouldHave(text("You entered: " + Keys.TAB.name()));
    }
}
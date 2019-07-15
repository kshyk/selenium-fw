package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.Test;

import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HoversPageTests extends TestCase {
    @Test
    public void isHoversPageLoaded() {
        open("http://the-internet.herokuapp.com/hovers");
        $(byText("Hovers")).should(appear);
    }

    @Test(dependsOnMethods = "isHoversPageLoaded")
    public void isAdditionalInfoPresentAfterHoverOverImage() {
        final var map = Map.of(0, "user1", 1, "user2", 2, "user3");
        map.forEach((index, name) -> {
            $$(".figure img").get(index).hover();
            $(byText("name: " + name)).should(appear);
        });
    }
}
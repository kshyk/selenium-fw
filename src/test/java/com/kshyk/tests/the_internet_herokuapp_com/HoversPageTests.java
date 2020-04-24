package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

class HoversPageTests extends TestCase {
    @Test
    public void additionalInfoShouldAppearOnImageHover() {
        open("http://the-internet.herokuapp.com/hovers");
        Map.of(0, "user1", 1, "user2", 2, "user3")
                .forEach((index, name) -> {
                    $$(".figure img").get(index)
                            .hover();
                    $(byText("name: " + name)).should(appear);
                });
    }
}
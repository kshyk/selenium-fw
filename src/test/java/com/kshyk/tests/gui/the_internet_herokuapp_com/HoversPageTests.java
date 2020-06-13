package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.pageobjects.theinternetherokuapp.HoversPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HoversPageTests extends TestCase {
    @Test
    public void additionalInfoShouldAppearOnImageHover() {
        var page = open("http://the-internet.herokuapp.com/hovers", HoversPage.class);
        Map.of(0, "user1", 1, "user2", 2, "user3")
                .forEach((index, name) -> {
                    page.mouseOverImageByIndex(index);
                    assertTrue($(byText("name: " + name)).isDisplayed());
                });
    }
}
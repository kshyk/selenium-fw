package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.HoversPageHelper;
import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HoversPageTests extends TestCase {
    @BeforeAll
    public void openHoversPage() {
        open("http://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void additionalInfoShouldAppearOnImageHover() {
        var users = List.of("user1", "user2", "user3");
        users.forEach(user -> {
            HoversPageHelper.mouseOverImageByIndex(users.indexOf(user));
            assertTrue(PageContent.getContentText().contains("name: " + user));
        });
    }
}
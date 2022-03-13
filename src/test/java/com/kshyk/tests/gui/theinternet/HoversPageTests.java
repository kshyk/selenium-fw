package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.HoversPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

class HoversPageTests extends TheInternetTestCase {
    private HoversPage page;

    @BeforeAll
    void openHoversPage() {
        page = HoversPage.open();
    }

    @Test
    void additionalInfoShouldAppearOnImageHover() {
        var assertions = new SoftAssertions();
        var users = List.of("user1", "user2", "user3");
        IntStream.range(0, users.size()).forEach(i -> {
            var user = users.get(i);
            assertions.assertThat(page.mouseOverImageByIndex(i).getContentText())
                .as("Mouse is not over %s image", user)
                .contains("name: " + user);
        });
        assertions.assertAll();
    }
}

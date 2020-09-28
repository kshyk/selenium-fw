package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.HoversPageHelper;
import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HoversPageTests extends TestCase {
    @BeforeAll
    public void openHoversPage() {
        open("http://the-internet.herokuapp.com/hovers");
    }

    @ParameterizedTest(name = "{1}AdditionalInfoShouldAppearOnImageHover")
    @MethodSource("mapSource")
    public void additionalInfoShouldAppearOnImageHover(int index, String user) {
        HoversPageHelper.mouseOverImageByIndex(index);
        assertTrue(PageContent.getContentText().contains("name: " + user));
    }

    private Stream<Arguments> mapSource() {
        var users = List.of("user1", "user2", "user3");
        return IntStream.range(0, users.size())
                .mapToObj(index -> Arguments.arguments(index, users.get(index)));
    }
}
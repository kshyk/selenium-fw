package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.DropdownPageHelper;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DropdownListTests extends TestCase {
    @BeforeAll
    void openDropdownPage() {
        open("http://the-internet.herokuapp.com/dropdown");
    }

    @ParameterizedTest(name = "optionShouldBeSelectedByValue{0}")
    @ValueSource(ints = {1, 2})
    void optionSelectionByValue(int value) {
        DropdownPageHelper.selectByValue("" + value);
        assertEquals("Option " + value, DropdownPageHelper.getSelectedText());
    }

    @ParameterizedTest(name = "optionShouldBeSelectedByIndex{0}")
    @ValueSource(ints = {1, 2})
    void optionSelectionByIndex(int index) {
        DropdownPageHelper.selectByIndex(index);
        assertEquals("Option " + index, DropdownPageHelper.getSelectedText());
    }

    @ParameterizedTest(name = "optionShouldBeSelectedByVisibleText{0}")
    @ValueSource(strings = {"Option 1", "Option 2"})
    void optionSelectionByVisibleText(String text) {
        DropdownPageHelper.selectByVisibleText(text);
        assertEquals(text, DropdownPageHelper.getSelectedText());
    }
}

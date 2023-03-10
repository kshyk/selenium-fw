package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.DropdownPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DropdownListTests extends TheInternetTestCase {
    private DropdownPage page;

    @BeforeAll
    void openDropdownPage() {
        page = DropdownPage.open();
    }

    @ParameterizedTest(name = "check{0}OptionSelection")
    @ValueSource(ints = {1, 2})
    void checkAllOptionSelectionCombinations(int index) {
        var expected = "Option " + index;
        page.selectByValue(String.valueOf(index));
        softly.then(page.getSelectedText())
            .as("Wrong value selection for %d option", index).isEqualTo(expected);
        page.selectByIndex(index);
        softly.then(page.getSelectedText())
            .as("Wrong index selection for %d option", index).isEqualTo(expected);
        page.selectByVisibleText(expected);
        softly.then(page.getSelectedText())
            .as("Wrong text selection for %d option", index).isEqualTo(expected);
    }
}

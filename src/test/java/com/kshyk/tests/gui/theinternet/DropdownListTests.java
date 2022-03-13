package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.DropdownPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class DropdownListTests extends TheInternetTestCase {
    private DropdownPage page;

    @BeforeAll
    void openDropdownPage() {
        page = DropdownPage.open();
    }

    @Test
    void checkAllOptionSelectionCombinations() {
        var assertions = new SoftAssertions();
        IntStream.rangeClosed(1, 2).forEach(index -> {
            var expected = "Option " + index;
            page.selectByValue("" + index);
            assertions.assertThat(page.getSelectedText())
                .as("Wrong value selection for %d option", index).isEqualTo(expected);
            page.selectByIndex(index);
            assertions.assertThat(page.getSelectedText())
                .as("Wrong index selection for %d option", index).isEqualTo(expected);
            page.selectByVisibleText(expected);
            assertions.assertThat(page.getSelectedText())
                .as("Wrong text selection for %d option", index).isEqualTo(expected);
        });
        assertions.assertAll();
    }
}

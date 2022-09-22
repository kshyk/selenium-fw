package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.CheckboxesPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CheckboxesTests extends TheInternetTestCase {
    private CheckboxesPage page;

    @BeforeAll
    void openCheckboxesPage() {
        page = CheckboxesPage.open();
        page.allCheckboxSelection(false);
    }

    @Test
    void checkAllSelectionCombinations() {
        softly.then(page.isCheckboxSelected(0)).as("First checkbox is selected").isFalse();
        softly.then(page.isCheckboxSelected(1)).as("Second checkbox is selected").isFalse();
        page.tickCheckbox(0, true);
        softly.then(page.isCheckboxSelected(0)).as("First checkbox is not selected").isTrue();
        page.tickCheckbox(1, true);
        softly.then(page.isCheckboxSelected(1)).as("Second checkbox is not selected").isTrue();
        page.tickCheckbox(0, false);
        softly.then(page.isCheckboxSelected(0)).as("First checkbox is still selected").isFalse();
    }
}

package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.CheckboxesPage;
import org.assertj.core.api.SoftAssertions;
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
        var assertions = new SoftAssertions();
        assertions.assertThat(page.isCheckboxSelected(0)).as("First checkbox is selected").isFalse();
        assertions.assertThat(page.isCheckboxSelected(1)).as("Second checkbox is selected").isFalse();
        page.tickCheckbox(0, true);
        assertions.assertThat(page.isCheckboxSelected(0)).as("First checkbox is not selected").isTrue();
        page.tickCheckbox(1, true);
        assertions.assertThat(page.isCheckboxSelected(1)).as("Second checkbox is not selected").isTrue();
        page.tickCheckbox(0, false);
        assertions.assertThat(page.isCheckboxSelected(0)).as("First checkbox is still selected").isFalse();
        assertions.assertAll();
    }
}

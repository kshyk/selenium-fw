package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.CheckboxesPageHelper;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CheckboxesTests extends TestCase {
    @BeforeAll
    void openCheckboxesPage() {
        open("http://the-internet.herokuapp.com/checkboxes");
        CheckboxesPageHelper.allCheckboxSelection(false);
    }

    @Test
    @Order(1)
    void allCheckboxesShouldBeDeselected() {
        assertAll(() -> assertFalse(CheckboxesPageHelper.isCheckboxSelected(0)),
                () -> assertFalse(CheckboxesPageHelper.isCheckboxSelected(1)));
    }

    @Test
    @Order(2)
    void firstCheckboxShouldBeSelected() {
        CheckboxesPageHelper.tickCheckbox(0, true);
        assertAll(() -> assertTrue(CheckboxesPageHelper.isCheckboxSelected(0)),
                () -> assertFalse(CheckboxesPageHelper.isCheckboxSelected(1)));
    }

    @Test
    @Order(3)
    void allCheckboxesShouldBeSelected() {
        CheckboxesPageHelper.tickCheckbox(1, true);
        assertAll(() -> assertTrue(CheckboxesPageHelper.isCheckboxSelected(0)),
                () -> assertTrue(CheckboxesPageHelper.isCheckboxSelected(1)));
    }

    @Test
    @Order(4)
    void secondCheckboxShouldBeSelected() {
        CheckboxesPageHelper.tickCheckbox(0, false);
        assertAll(() -> assertFalse(CheckboxesPageHelper.isCheckboxSelected(0)),
                () -> assertTrue(CheckboxesPageHelper.isCheckboxSelected(1)));
    }
}

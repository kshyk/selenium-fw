package com.kshyk.helpers.theinternetherokuapp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class CheckboxesPageHelper {
    private CheckboxesPageHelper() {
    }

    public static void allCheckboxSelection(boolean shouldBeSelected) {
        var checkboxes = getCheckboxes();
        checkboxes.forEach(checkbox -> tickCheckbox(checkboxes.indexOf(checkbox), shouldBeSelected));
    }

    public static boolean isCheckboxSelected(int index) {
        return getCheckboxByIndex(index).isSelected();
    }

    public static void tickCheckbox(int index, boolean state) {
        var checkbox = getCheckboxByIndex(index);
        if (state && !checkbox.isSelected()) {
            checkbox.click();
        } else {
            if (checkbox.isSelected())
                checkbox.click();
        }
    }

    private static ElementsCollection getCheckboxes() {
        return $$("#checkboxes input");
    }

    private static SelenideElement getCheckboxByIndex(int index) {
        return getCheckboxes().get(index);
    }
}
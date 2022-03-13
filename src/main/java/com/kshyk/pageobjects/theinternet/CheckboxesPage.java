package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$$;

public class CheckboxesPage {
    private final ElementsCollection checkboxes = $$("#checkboxes input");

    public static CheckboxesPage open() {
        Selenide.open("/checkboxes");
        return new CheckboxesPage();
    }

    public void allCheckboxSelection(boolean shouldBeSelected) {
        checkboxes.asDynamicIterable().forEach(checkbox ->
            tickCheckbox(checkboxes.indexOf(checkbox), shouldBeSelected));
    }

    public boolean isCheckboxSelected(int index) {
        return checkboxes.get(index).isSelected();
    }

    public void tickCheckbox(int index, boolean state) {
        var checkbox = checkboxes.get(index);
        if (state && !checkbox.isSelected()) {
            checkbox.click();
        } else {
            if (checkbox.isSelected())
                checkbox.click();
        }
    }
}

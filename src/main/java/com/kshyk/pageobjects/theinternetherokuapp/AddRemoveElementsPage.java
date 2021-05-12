package com.kshyk.pageobjects.theinternetherokuapp;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddRemoveElementsPage {
    private final ElementsCollection deleteButtons = $$("button[onclick='deleteElement()']");

    public void clickOnAddElementButton() {
        $("button[onclick='addElement()']").click();
    }

    public void clickOnDeleteButton() {
        deleteButtons.get(0).click();
    }

    public void deleteButtonShouldHaveSize(int size) {
        deleteButtons.shouldHave(size(size));
    }
}
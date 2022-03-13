package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import java.util.stream.IntStream;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddRemoveElementsPage {
    private final ElementsCollection deleteButtons = $$("button[onclick='deleteElement()']");

    public static AddRemoveElementsPage open() {
        Selenide.open("/add_remove_elements/");
        return new AddRemoveElementsPage();
    }

    public AddRemoveElementsPage addElements(int elementsToAdd) {
        IntStream.range(0, elementsToAdd).forEach(i -> $("button[onclick='addElement()']").click());
        return this;
    }

    public AddRemoveElementsPage removeElements(int elementsToRemove) {
        IntStream.range(0, elementsToRemove).forEach(i -> deleteButtons.get(0).click());
        return this;
    }

    public void deleteButtonShouldHaveSize(int size) {
        deleteButtons.shouldHave(size(size));
    }
}

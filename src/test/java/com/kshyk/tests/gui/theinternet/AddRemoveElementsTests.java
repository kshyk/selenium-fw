package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.AddRemoveElementsPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class AddRemoveElementsTests extends TheInternetTestCase {
    private static final int LOOPS = 3;
    private AddRemoveElementsPage page;

    @BeforeAll
    void openAddRemoveElementsPage() {
        page = AddRemoveElementsPage.open();
    }

    @TestFactory
    Iterable<DynamicTest> addAndRemoveElementTest() {
        var tests = new ArrayList<DynamicTest>(LOOPS * 2);
        IntStream.rangeClosed(1, LOOPS).forEach(n -> {
            tests.add(dynamicTest("addElementsAmountOf" + n,
                () -> page.addElements(n).deleteButtonShouldHaveSize(n)));
            tests.add(dynamicTest("removeElementsAmountOf" + n,
                () -> page.removeElements(n).deleteButtonShouldHaveSize(0)));
        });
        return tests;
    }
}

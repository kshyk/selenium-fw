package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.pageobjects.theinternetherokuapp.AddRemoveElementsPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class AddRemoveElementsTests extends TestCase {
    private static final int LOOPS = 3;
    private AddRemoveElementsPage page;

    @BeforeAll
    public void openAddRemoveElementsPage() {
        page = open("http://the-internet.herokuapp.com/add_remove_elements/", AddRemoveElementsPage.class);
    }

    @TestFactory
    public Iterable<DynamicTest> addAndRemoveElementTest() {
        Collection<DynamicTest> tests = new ArrayList<>(LOOPS * 2);
        IntStream.rangeClosed(1, LOOPS).forEach(n -> {
            Executable addTest = () -> {
                IntStream.range(0, n).forEach($$ -> page.clickOnAddElementButton());
                page.deleteButtonShouldHaveSize(n);
            };
            tests.add(dynamicTest("addElementsAmountOf" + n, addTest));
            Executable removeTest = () -> {
                IntStream.range(0, n).forEach($$ -> page.clickOnDeleteButton());
                page.deleteButtonShouldHaveSize(0);
            };
            tests.add(dynamicTest("removeElementsAmountOf" + n, removeTest));
        });
        return tests;
    }
}
package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.helpers.theinternetherokuapp.MultipleWindowsPageHelper;
import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleWindowsPageTests extends TestCase {
    @BeforeAll
    void openMultipleWindowsPage() {
        open("http://the-internet.herokuapp.com/windows");
    }

    @Test
    @Order(1)
    void isNewWindowOpened() {
        MultipleWindowsPageHelper.openNewWindow();
        assertEquals("New Window", PageContent.getTitleText());
    }

    @Test
    @Order(2)
    void isDefaultContentPresentAfterNewWindowClose() {
        MultipleWindowsPageHelper.closeNewWindow();
        assertEquals("Opening a new window", PageContent.getTitleText());
    }
}

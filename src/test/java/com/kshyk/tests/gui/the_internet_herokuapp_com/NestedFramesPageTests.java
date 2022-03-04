package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.enums.theinternetherokuapp.Frame;
import com.kshyk.helpers.theinternetherokuapp.NestedFramesPageHelper;
import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.kshyk.enums.theinternetherokuapp.Frame.BOTTOM;
import static com.kshyk.enums.theinternetherokuapp.Frame.TOP;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NestedFramesPageTests extends TestCase {
    @BeforeAll
    void openNestedFramesPage() {
        open("http://the-internet.herokuapp.com/nested_frames");
    }

    @ParameterizedTest(name = "is{0}FrameLocatedProperly")
    @EnumSource(value = Frame.class, names = {"BOTTOM", "LEFT", "MIDDLE", "RIGHT"})
    void isFrameLocatedProperly(Frame frame) {
        if (!frame.equals(BOTTOM))
            NestedFramesPageHelper.switchToInnerFrame(TOP);
        NestedFramesPageHelper.switchToFrame(frame);
        assertEquals(frame.name(), PageContent.getBodyText());
    }

    @BeforeEach
    void switchToDefaultContent() {
        switchTo().defaultContent();
    }
}

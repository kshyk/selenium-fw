package com.kshyk.tests.gui.theinternet;

import com.kshyk.enums.theinternetherokuapp.Frame;
import com.kshyk.pageobjects.theinternet.NestedFramesPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.kshyk.enums.theinternetherokuapp.Frame.BOTTOM;
import static com.kshyk.enums.theinternetherokuapp.Frame.TOP;
import static org.assertj.core.api.Assertions.assertThat;

class NestedFramesPageTests extends TheInternetTestCase {
    private NestedFramesPage page;

    @BeforeAll
    void openNestedFramesPage() {
        page = NestedFramesPage.open();
    }

    @ParameterizedTest(name = "is{0}FrameLocatedProperly")
    @EnumSource(value = Frame.class, names = {"BOTTOM", "LEFT", "MIDDLE", "RIGHT"})
    void isFrameLocatedProperly(Frame frame) {
        switchTo().defaultContent();
        if (!frame.equals(BOTTOM))
            page.switchToInnerFrame(TOP);
        page.switchToFrame(frame);
        assertThat(page.getBodyText()).as("Cannot switch to %s frame", frame).isEqualTo(frame.name());
    }
}

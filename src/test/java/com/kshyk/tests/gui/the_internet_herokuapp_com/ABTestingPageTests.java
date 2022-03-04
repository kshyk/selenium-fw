package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

class ABTestingPageTests extends TestCase {
    @BeforeAll
    void openABTestPage() {
        open("http://the-internet.herokuapp.com/abtest");
    }

    @Test
    void isABTestPageLoaded() {
        assertThat(PageContent.getTitleText()).contains("A/B Test");
    }
}

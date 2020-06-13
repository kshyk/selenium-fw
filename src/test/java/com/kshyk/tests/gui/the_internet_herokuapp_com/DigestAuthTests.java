package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.pageobjects.theinternetherokuapp.DigestAuthPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DigestAuthTests extends TestCase {
    private final DigestAuthPage page = new DigestAuthPage();

    @Test
    public void userShouldGrantAccessWithDigestAuth() {
        open("http://admin:admin@the-internet.herokuapp.com/digest_auth");
        assertAll(() -> assertThat(page.getTitleText()).isEqualTo("Digest Auth"),
                () -> assertThat(page.getContentText()).contains("Congratulations!"));
    }
}
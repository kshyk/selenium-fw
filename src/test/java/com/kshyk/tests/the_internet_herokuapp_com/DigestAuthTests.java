package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.pageobjects.theinternetherokuapp.DigestAuthPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DigestAuthTests extends TestCase {
    private final DigestAuthPage page = new DigestAuthPage();

    @Test
    void userShouldGrantAccessWithDigestAuth() {
        open("http://admin:admin@the-internet.herokuapp.com/digest_auth");
        page.titleShouldHaveText("Digest Auth")
                .pageShouldHaveText("Congratulations!");
    }
}
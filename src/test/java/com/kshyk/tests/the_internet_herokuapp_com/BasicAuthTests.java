package com.kshyk.tests.the_internet_herokuapp_com;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Credentials;
import com.kshyk.pageobjects.theinternetherokuapp.BasicAuthPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BasicAuthTests extends TestCase {
    private final BasicAuthPage page = new BasicAuthPage();

    @Test
    public void userShouldGrantAccessWithBasicAuth() {
        var url = "http://the-internet.herokuapp.com/basic_auth";
        var credentials = new Credentials("admin", "admin");
        open(url, AuthenticationType.BASIC, credentials);
        assertAll(() -> assertThat(page.getTitleText()).isEqualTo("Basic Auth"),
                () -> assertThat(page.getContentText()).contains("Congratulations!"));
    }
}
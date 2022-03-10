package com.kshyk.tests.gui.teamandpersonal_pl;

import com.codeborne.selenide.Configuration;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;

public abstract class TNPTestCase extends TestCase {
    @BeforeAll
    protected void configuration() {
        Configuration.baseUrl = "https://teamandpersonal.pl";
    }
}

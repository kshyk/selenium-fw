package com.kshyk.tests.gui.teamandpersonal;

import com.kshyk.pageobjects.teamandpersonal.CookiesBar;
import org.junit.jupiter.api.Test;

import static com.kshyk.common.Constants.COOKIES_TEXT;

class CookiesTests extends TNPTestCase {
    @Test
    void checkCookieBar() {
        var cookiesBar = new CookiesBar();
        softly.then(cookiesBar.isOpen()).as("Cookie Policy bar didn't appear").isTrue();
        softly.then(cookiesBar.getText()).as("Invalid Cookie Policy information text")
            .isEqualTo(COOKIES_TEXT);
        softly.then(cookiesBar.acceptCookies().isClosed())
            .as("Cookie Policy bar is still visible after close action").isTrue();
    }
}

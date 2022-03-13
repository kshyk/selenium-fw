package com.kshyk.tests.gui.theinternet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

class TinyMCEPageTests extends TheInternetTestCase {
    @BeforeAll
    void openTinyMCEPage() {
        open("/tinymce");
    }

    @Test
    void clearAndSetNewContent() {
        var jsCode = "tinymce.activeEditor.setContent(arguments[0]);";
        executeJavaScript(jsCode, "");
        executeJavaScript(jsCode, LocalDateTime.now().toString());
    }
}

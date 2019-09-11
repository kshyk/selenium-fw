package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TinyMCEPageTests extends TestCase {
    @Test
    public void clearAndSetNewContent() {
        open("http://the-internet.herokuapp.com/tinymce");
        var jsCode = "tinymce.activeEditor.setContent(arguments[0]);";
        executeJavaScript(jsCode, "");
        executeJavaScript(jsCode, LocalDateTime.now().toString());
    }
}
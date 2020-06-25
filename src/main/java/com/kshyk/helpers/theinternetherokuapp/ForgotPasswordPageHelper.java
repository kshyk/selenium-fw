package com.kshyk.helpers.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class ForgotPasswordPageHelper {
    private ForgotPasswordPageHelper() {
    }

    public static void retrievePassword(String email) {
        $(id("email")).val(email);
        $(id("form_submit")).submit();
    }
}
package com.kshyk.pageobjects.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class ForgotPasswordPage {
    public void retrievePassword(String email) {
        $(id("email")).val(email);
        $(id("form_submit")).submit();
    }
}
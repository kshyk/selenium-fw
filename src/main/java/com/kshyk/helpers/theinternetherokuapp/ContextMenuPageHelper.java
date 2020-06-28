package com.kshyk.helpers.theinternetherokuapp;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class ContextMenuPageHelper {
    private ContextMenuPageHelper() {
    }

    public static void contextClickOnHotSpot() {
        $(id("hot-spot")).contextClick();
    }
}

package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class ContextMenuPage {
    public static ContextMenuPage open() {
        return Selenide.open("/context_menu", ContextMenuPage.class);
    }

    public void contextClickOnHotSpot() {
        $("#hot-spot").hover().contextClick();
    }
}

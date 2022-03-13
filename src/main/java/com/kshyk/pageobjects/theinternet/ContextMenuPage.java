package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class ContextMenuPage {
    public static ContextMenuPage open() {
        Selenide.open("/context_menu");
        return new ContextMenuPage();
    }

    public void contextClickOnHotSpot() {
        $("#hot-spot").hover().contextClick();
    }
}

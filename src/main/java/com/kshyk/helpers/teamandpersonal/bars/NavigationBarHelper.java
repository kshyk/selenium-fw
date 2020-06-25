package com.kshyk.helpers.teamandpersonal.bars;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public class NavigationBarHelper {
    private static final SelenideElement topkaMail = $(".topka-mail a");

    private NavigationBarHelper() {
    }

    public static String getTelephoneText() {
        return $(className("topka-tel")).text();
    }

    public static String getMailHrefValue() {
        return topkaMail.getAttribute("href");
    }

    public static String getMailText() {
        return topkaMail.text().trim();
    }
}
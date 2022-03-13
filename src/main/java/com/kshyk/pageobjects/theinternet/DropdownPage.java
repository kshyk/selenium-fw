package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class DropdownPage {
    private final SelenideElement dropdown = $("#dropdown");

    public static DropdownPage open() {
        Selenide.open("/dropdown");
        return new DropdownPage();
    }

    public void selectByValue(String value) {
        new Select(dropdown).selectByValue(value);
    }

    public void selectByIndex(int index) {
        new Select(dropdown).selectByIndex(index);
    }

    public void selectByVisibleText(String text) {
        new Select(dropdown).selectByVisibleText(text);
    }

    public String getSelectedText() {
        return dropdown.text().trim();
    }
}

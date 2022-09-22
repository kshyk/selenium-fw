package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.openqa.selenium.Keys.COMMAND;
import static org.openqa.selenium.Keys.CONTROL;

public class MultipleWindowsPage implements PageContent {
    public static MultipleWindowsPage open() {
        Selenide.open("/windows");
        return new MultipleWindowsPage();
    }

    public void openNewWindow() {
        $(byLinkText("Click Here")).hover().click();
        switchTo().window("New Window");
    }

    public void closeNewWindow() {
        var currentPlatform = Platform.fromString(System.getProperty("os.name"));
        boolean isMacOS = Platform.MAC.is(currentPlatform);
        actions().sendKeys(Keys.chord(isMacOS ? COMMAND : CONTROL, "W")).perform();
        switchTo().window(0);
    }
}

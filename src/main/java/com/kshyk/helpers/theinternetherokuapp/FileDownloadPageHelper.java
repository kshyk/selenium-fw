package com.kshyk.helpers.theinternetherokuapp;

import com.kshyk.interfaces.PageContent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;
import static java.util.stream.Collectors.toList;

public class FileDownloadPageHelper {
    private FileDownloadPageHelper() {
    }

    public static List<String> getFileNames() {
        return PageContent.getLinks().stream().map(WebElement::getText).collect(toList());
    }

    public static File downloadFile(String fileName) {
        try {
            return $(By.partialLinkText(fileName)).download();
        } catch (FileNotFoundException e) {
            Logger.getGlobal().warning("Cannot find file: " + fileName);
        }
        return null;
    }
}

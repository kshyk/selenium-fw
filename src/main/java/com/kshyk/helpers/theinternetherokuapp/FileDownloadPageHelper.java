package com.kshyk.helpers.theinternetherokuapp;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;

public class FileDownloadPageHelper {
    private FileDownloadPageHelper() {
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

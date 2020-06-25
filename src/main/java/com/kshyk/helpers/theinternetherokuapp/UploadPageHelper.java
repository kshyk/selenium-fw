package com.kshyk.helpers.theinternetherokuapp;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class UploadPageHelper {
    private UploadPageHelper() {
    }

    public static void uploadFile(File file) {
        $(id("file-upload")).uploadFile(file);
        $(id("file-submit")).submit();
    }

    public static String getUploadedFilesText() {
        return $(id("uploaded-files")).text();
    }
}
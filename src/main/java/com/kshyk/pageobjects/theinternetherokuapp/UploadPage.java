package com.kshyk.pageobjects.theinternetherokuapp;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class UploadPage {
    public void uploadFile(File file) {
        $(id("file-upload")).uploadFile(file);
        $(id("file-submit")).submit();
    }

    public String getUploadedFilesText() {
        return $("#uploaded-files").getText();
    }
}
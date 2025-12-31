package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.Selenide;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UploadPage implements PageContent {
    public static UploadPage open() {
        return Selenide.open("/upload", UploadPage.class);
    }

    public void uploadFile(File file) {
        $("#file-upload").uploadFile(file);
        $("#file-submit").submit();
    }

    public String getUploadedFilesText() {
        return $("#uploaded-files").text();
    }
}

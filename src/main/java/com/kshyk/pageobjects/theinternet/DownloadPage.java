package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.BasicAuthCredentials;
import com.codeborne.selenide.Selenide;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.AuthenticationType.BASIC;
import static com.codeborne.selenide.Selenide.$;

public class DownloadPage implements PageContent {
    public static DownloadPage openDownload() {
        Selenide.open("/download");
        return new DownloadPage();
    }

    public static DownloadPage openSecureDownload() {
        var credentials = new BasicAuthCredentials("admin", "admin");
        Selenide.open("/download_secure", BASIC, credentials);
        return new DownloadPage();
    }

    @SneakyThrows
    public File downloadFile(String fileName) {
        return $(By.partialLinkText(fileName)).download();
    }
}

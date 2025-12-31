package com.kshyk.pageobjects.theinternet;

import com.codeborne.selenide.BasicAuthCredentials;
import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.FileNotDownloadedError;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.AuthenticationType.BASIC;
import static com.codeborne.selenide.Selenide.$;
import static com.kshyk.common.EnvHolder.ADMIN_PASSWORD;

public class DownloadPage implements PageContent {
    public static DownloadPage openDownload() {
        return Selenide.open("/download", DownloadPage.class);
    }

    public static DownloadPage openSecureDownload() {
        var credentials = new BasicAuthCredentials("admin", ADMIN_PASSWORD);
        Selenide.open("/download_secure", BASIC, credentials);
        return new DownloadPage();
    }

    @SneakyThrows
    public File downloadFile(String fileName) {
        var link = $(By.partialLinkText(fileName));
        try {
            return link.download();
        } catch (FileNotDownloadedError e) {
            return link.download(DownloadOptions.using(FileDownloadMode.CDP));
        }
    }
}

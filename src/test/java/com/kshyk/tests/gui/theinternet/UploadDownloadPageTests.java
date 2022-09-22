package com.kshyk.tests.gui.theinternet;

import com.kshyk.common.FileUtil;
import com.kshyk.pageobjects.theinternet.DownloadPage;
import com.kshyk.pageobjects.theinternet.UploadPage;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.kshyk.enums.theinternetherokuapp.DownloadableFile.NOT_EMPTY;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UploadDownloadPageTests extends TheInternetTestCase {
    private UploadPage uploadPage;
    private String fileName;

    @BeforeAll
    void preconditions() {
        uploadPage = UploadPage.open();
        fileName = NOT_EMPTY.getFileName();
    }

    @Test
    @SneakyThrows
    @Order(1)
    void fileUploadedMessageShouldBePresent() {
        uploadPage.uploadFile(FileUtil.getFileByName(fileName));
        softly.then(uploadPage.getTitleText())
            .as("Wrong title after file upload").isEqualTo("File Uploaded!");
        softly.then(uploadPage.getUploadedFilesText())
            .as("Wrong filename after file upload").isEqualTo(fileName);
    }

    @Test
    @Order(2)
    void checkDownloadedFileName() {
        var downloadPage = DownloadPage.openDownload();
        softly.then(downloadPage.downloadFile(fileName).getName())
            .as("Cannot download %s file", fileName).isEqualTo(fileName);
        downloadPage = DownloadPage.openSecureDownload();
        softly.then(downloadPage.downloadFile(fileName).getName())
            .as("Cannot download %s secure file", fileName).isEqualTo(fileName);
    }
}

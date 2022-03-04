package com.kshyk.tests.gui.the_internet_herokuapp_com.filedownload;

import com.codeborne.selenide.BasicAuthCredentials;
import com.kshyk.helpers.theinternetherokuapp.FileDownloadPageHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;

import static com.codeborne.selenide.AuthenticationType.BASIC;
import static com.codeborne.selenide.Selenide.open;
import static com.kshyk.helpers.theinternetherokuapp.FileDownloadPageHelper.downloadFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SecureFileDownloadTests extends FileDownloadTestCase {
    @BeforeAll
    void openSecureFileDownloadPage() {
        var credentials = new BasicAuthCredentials("admin", "admin");
        open("http://the-internet.herokuapp.com/download_secure", BASIC, credentials);
        fileNames = FileDownloadPageHelper.getFileNames();
    }

    @ParameterizedTest(name = "checkSecuredDownloadedFile{0}Name")
    @MethodSource("com.kshyk.tests.gui.the_internet_herokuapp_com.filedownload.FileDownloadTestCase#checkDownloadedFileName")
    void checkSecuredDownloadedFileName(String fileName) {
        var expected = fileName.replaceAll(" ", "+");
        assertEquals(expected, Objects.requireNonNull(downloadFile(fileName)).getName());
    }
}

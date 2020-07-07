package com.kshyk.tests.gui.the_internet_herokuapp_com.filedownload;

import com.kshyk.helpers.theinternetherokuapp.FileDownloadPageHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.kshyk.helpers.theinternetherokuapp.FileDownloadPageHelper.downloadFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileDownloadTests extends FileDownloadTestCase {
    @BeforeAll
    public void openFileDownloadPage() {
        open("http://the-internet.herokuapp.com/download");
        fileNames = FileDownloadPageHelper.getFileNames();
    }

    @ParameterizedTest(name = "checkDownloadedFile{0}Name")
    @MethodSource("com.kshyk.tests.gui.the_internet_herokuapp_com.filedownload.FileDownloadTestCase#checkDownloadedFileName")
    public void checkDownloadedFileName(String fileName) {
        assertEquals(fileName, Objects.requireNonNull(downloadFile(fileName)).getName());
    }
}
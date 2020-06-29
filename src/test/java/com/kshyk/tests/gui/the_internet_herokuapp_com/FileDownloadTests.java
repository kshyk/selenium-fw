package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.common.FileUtil;
import com.kshyk.enums.theinternetherokuapp.DownloadableFile;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.kshyk.helpers.theinternetherokuapp.FileDownloadPageHelper.downloadFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileDownloadTests extends TestCase {
    private File actual;

    @BeforeAll
    public void openSecureFileDownloadPage() {
        open("http://the-internet.herokuapp.com/download");
    }

    @ParameterizedTest(name = "checkDownloadedFile{0}Name")
    @EnumSource(DownloadableFile.class)
    public void checkDownloadedFileName(DownloadableFile downloadableFile) throws IOException {
        var fileName = downloadableFile.getFileName();
        var expected = FileUtil.getFileByName(fileName);
        actual = Objects.requireNonNull(downloadFile(fileName));
        assertEquals(expected.getName(), actual.getName());
    }

    @AfterEach
    public void deleteDownloadedFile() throws IOException {
        Files.deleteIfExists(actual.toPath());
    }
}
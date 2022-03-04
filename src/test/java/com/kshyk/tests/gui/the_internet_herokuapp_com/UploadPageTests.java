package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.common.FileUtil;
import com.kshyk.enums.theinternetherokuapp.DownloadableFile;
import com.kshyk.helpers.theinternetherokuapp.UploadPageHelper;
import com.kshyk.interfaces.PageContent;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UploadPageTests extends TestCase {
    private static final String FILE_NAME = DownloadableFile.NOT_EMPTY.getFileName();

    @BeforeAll
    void uploadFile() throws IOException {
        open("http://the-internet.herokuapp.com/upload");
        UploadPageHelper.uploadFile(FileUtil.getFileByName(FILE_NAME));
    }

    @Test
    void fileUploadedMessageShouldBePresent() {
        assertEquals("File Uploaded!", PageContent.getTitleText());
    }

    @Test
    void fileNameShouldBePresentInPanel() {
        assertEquals(FILE_NAME, UploadPageHelper.getUploadedFilesText());
    }
}

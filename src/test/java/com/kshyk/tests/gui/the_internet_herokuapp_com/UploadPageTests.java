package com.kshyk.tests.gui.the_internet_herokuapp_com;

import com.kshyk.common.FileUtil;
import com.kshyk.pageobjects.theinternetherokuapp.UploadPage;
import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UploadPageTests extends TestCase {
    @Test
    public void isFileProperlyUploaded() throws IOException {
        var page = open("http://the-internet.herokuapp.com/upload", UploadPage.class);
        var file = FileUtil.getFileByName("not_empty.txt");
        page.uploadFile(file);
        assertAll(() -> assertTrue($(byText("File Uploaded!")).isDisplayed()),
                () -> assertEquals(file.getName(), page.getUploadedFilesText()));
    }
}
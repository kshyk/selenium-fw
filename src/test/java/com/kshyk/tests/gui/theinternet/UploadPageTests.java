package com.kshyk.tests.gui.theinternet;

import com.kshyk.common.FileUtil;
import com.kshyk.pageobjects.theinternet.UploadPage;
import lombok.SneakyThrows;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.kshyk.enums.theinternetherokuapp.DownloadableFile.NOT_EMPTY;

class UploadPageTests extends TheInternetTestCase {
    private UploadPage page;

    @BeforeAll
    void openUploadPage() {
        page = UploadPage.open();
    }

    @Test
    @SneakyThrows
    void fileUploadedMessageShouldBePresent() {
        var fileName = NOT_EMPTY.getFileName();
        page.uploadFile(FileUtil.getFileByName(fileName));
        var assertions = new SoftAssertions();
        assertions.assertThat(page.getTitleText())
            .as("Wrong title after file upload").isEqualTo("File Uploaded!");
        assertions.assertThat(page.getUploadedFilesText())
            .as("Wrong filename after file upload").isEqualTo(fileName);
        assertions.assertAll();
    }
}

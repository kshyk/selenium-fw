package com.kshyk.tests.gui.theinternet;

import com.kshyk.pageobjects.theinternet.DownloadPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DownloadTests extends TheInternetTestCase {
    private DownloadPage page;

    @BeforeAll
    void openFileDownloadPage() {
        page = DownloadPage.openDownload();
    }

    @Test
    void checkDownloadedFileName() {
        var fileName = page.getFileNames().get(0);
        var expected = fileName.replaceAll(" ", "+");
        var assertions = new SoftAssertions();
        assertions.assertThat(page.downloadFile(fileName).getName())
            .as("Cannot download %s file", fileName).isEqualTo(expected);
        page = DownloadPage.openSecureDownload();
        fileName = page.getFileNames().get(0);
        expected = fileName.replaceAll(" ", "+");
        assertions.assertThat(page.downloadFile(fileName).getName())
            .as("Cannot download %s secure file", fileName).isEqualTo(expected);
        assertions.assertAll();
    }
}

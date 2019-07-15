package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UploadPageTests extends TestCase {
    @Test
    public final void isUploadPageLoaded() {
        open("http://the-internet.herokuapp.com/upload");
        $(byText("File Uploader")).should(appear);
    }

    @Test(dependsOnMethods = "isUploadPageLoaded")
    public final void isFileProperlyUploaded() throws URISyntaxException {
        final var classLoader = UploadPageTests.class.getClassLoader();
        final var resource = classLoader.getResource("upload/not_empty.txt");
        final var fileURI = Objects.requireNonNull(resource).toURI();
        final var file = new File(fileURI);
        $("#file-upload").uploadFile(file);
        $("#file-submit").submit();
        $(byText("File Uploaded!")).should(appear);
        $("#uploaded-files").shouldHave(text(file.getName()));
    }
}
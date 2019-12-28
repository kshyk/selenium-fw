package com.kshyk.tests.the_internet_herokuapp_com;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class UploadPageTests extends TestCase {
    @Test
    public void isFileProperlyUploaded() throws IOException {
        open("http://the-internet.herokuapp.com/upload");
        var dir = Paths.get(System.getProperty("user.dir"));
        BiPredicate<Path, BasicFileAttributes> fileBiPredicate = (path, attrs) -> attrs.isRegularFile() && path.toString().endsWith("not_empty.txt");
        var file = Files.find(dir, Integer.MAX_VALUE, fileBiPredicate).findFirst().orElseThrow().toFile();
        $("#file-upload").uploadFile(file);
        $("#file-submit").submit();
        $(byText("File Uploaded!")).should(appear);
        $("#uploaded-files").shouldHave(text(file.getName()));
    }
}
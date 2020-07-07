package com.kshyk.tests.gui.the_internet_herokuapp_com.filedownload;

import com.kshyk.tests.base.TestCase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class FileDownloadTestCase extends TestCase {
    protected List<String> fileNames;

    protected Stream<Arguments> checkDownloadedFileName() {
        return fileNames.stream().map(Arguments::of);
    }
}
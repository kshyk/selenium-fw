package com.kshyk.common;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

import static java.lang.Integer.MAX_VALUE;

@UtilityClass
public class FileUtil {
    public static File getFileByName(String filename) throws IOException {
        BiPredicate<Path, BasicFileAttributes> fileBiPredicate =
            (path, attrs) -> attrs.isRegularFile() && path.toString().endsWith(filename);
        var dir = Paths.get(System.getProperty("user.dir"));
        try (var path = Files.find(dir, MAX_VALUE, fileBiPredicate)) {
            return path.findFirst().orElseThrow().toFile();
        }
    }
}

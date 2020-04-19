package com.kshyk.common;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.capitalize;

public class CommonUtil {
    private CommonUtil() {
        // Util class
    }

    public static String capitalizeEnumName(String input) {
        return Arrays.stream(input.split("_"))
                .map(s -> capitalize(s.toLowerCase()))
                .collect(joining());
    }
}
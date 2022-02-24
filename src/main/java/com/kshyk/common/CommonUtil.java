package com.kshyk.common;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.capitalize;

@UtilityClass
public class CommonUtil {
    public static String capitalizeEnumName(String input) {
        return Arrays.stream(input.split("_"))
                .map(s -> capitalize(s.toLowerCase()))
                .collect(joining());
    }
}
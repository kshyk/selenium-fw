package com.kshyk.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EnvHolder {
    public static final String KEY = System.getenv("TESTINGBOT_KEY");
    public static final String SECRET = System.getenv("TESTINGBOT_SECRET");

    private static String getValue(String key) {
        return getValue(key, "");
    }

    private static String getValue(String key, String fallback) {
        var value = System.getenv(key);
        return value == null ? fallback : value;
    }
}

package com.kshyk.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EnvHolder {
    public static final String ADMIN_PASSWORD = System.getenv("ADMIN_PASSWORD");
    public static final String KEY = System.getenv("TESTINGBOT_KEY");
    public static final String SECRET = System.getenv("TESTINGBOT_SECRET");
}

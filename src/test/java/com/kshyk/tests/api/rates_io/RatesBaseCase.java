package com.kshyk.tests.api.rates_io;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.time.format.DateTimeFormatter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class RatesBaseCase {
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @BeforeAll
    protected void setup() {
        RestAssured.baseURI = "https://api.ratesapi.io";
        RestAssured.basePath = "/api";
    }
}
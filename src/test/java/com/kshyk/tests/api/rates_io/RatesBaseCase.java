package com.kshyk.tests.api.rates_io;

import com.kshyk.entities.rates.Rate;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class RatesBaseCase {
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    protected final LocalDate currentDate = LocalDate.now();
    protected Response response;
    protected Rate rate;

    @BeforeAll
    protected void setup() {
        RestAssured.baseURI = "https://api.ratesapi.io";
        RestAssured.basePath = "/api";
    }
}
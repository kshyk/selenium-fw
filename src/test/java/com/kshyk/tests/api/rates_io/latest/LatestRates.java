package com.kshyk.tests.api.rates_io.latest;

import com.kshyk.common.DateUtil;
import com.kshyk.entities.rates.Rate;
import com.kshyk.enums.rates.Currency;
import com.kshyk.tests.api.rates_io.RatesBaseCase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LatestRates extends RatesBaseCase {
    private Response response;
    private Rate latestRate;

    @BeforeAll
    public void getLatestRates() {
        response = RestAssured.get("/latest");
        latestRate = response.then().extract().as(Rate.class);
    }

    @Test
    public void statusCodeShouldBeOK() {
        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

    @Test
    public void latestDateShouldBeLastWorkingDayOfMonth() {
        assertEquals(DateUtil.getLastWorkingDayOfMonth(LocalDate.now()),
                LocalDate.parse(latestRate.getDate(), DATE_FORMATTER));
    }

    @Test
    public void baseCurrencyShouldBeEuro() {
        assertEquals(Currency.EURO.getInitial(), latestRate.getBase());
    }
}
package com.kshyk.tests.api.rates_io.dates;

import com.kshyk.common.DateUtil;
import com.kshyk.entities.rates.Rate;
import com.kshyk.enums.rates.Currency;
import com.kshyk.tests.api.rates_io.RatesBaseCase;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentDateRates extends RatesBaseCase {
    @BeforeAll
    public void getCurrentRates() {
        response = RestAssured.get("/" + currentDate);
        rate = response.then().extract().as(Rate.class);
    }

    @Test
    public void statusCodeShouldBeOK() {
        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

    @Test
    public void currentDateShouldBeLastWorkingDayOfMonth() {
        assertEquals(DateUtil.getLastWorkingDayOfMonth(currentDate), LocalDate.parse(rate.getDate(), DATE_FORMATTER));
    }

    @Test
    public void baseCurrencyShouldBeEuro() {
        assertEquals(Currency.EURO.getInitial(), rate.getBase());
    }
}

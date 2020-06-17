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

public class PreviousDateRates extends RatesBaseCase {
    private final LocalDate previousDate = LocalDate.now().minusWeeks(3);

    @BeforeAll
    public void getPreviousRates() {
        response = RestAssured.get("/" + previousDate);
        rate = response.then().extract().as(Rate.class);
    }

    @Test
    public void statusCodeShouldBeOK() {
        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

    @Test
    public void previousDateShouldBePastAndLastWorkingDayOfMonth() {
        assertEquals(DateUtil.getLastWorkingDayOfMonth(previousDate), LocalDate.parse(rate.getDate(), DATE_FORMATTER));
    }

    @Test
    public void baseCurrencyShouldBeEuro() {
        assertEquals(Currency.EURO.getInitial(), rate.getBase());
    }
}

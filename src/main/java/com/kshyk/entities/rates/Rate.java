package com.kshyk.entities.rates;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Rate {
    @JsonProperty(value = "base")
    private String base;
    @JsonProperty(value = "rates")
    private Map<String, Double> rates;
    @JsonProperty(value = "date")
    private String date;

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public String getDate() {
        return date;
    }
}
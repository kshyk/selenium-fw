package com.kshyk.enums.rates;

import com.kshyk.common.CommonUtil;

public enum Currency {
    EURO("EUR");

    private final String initial;

    Currency(String initial) {
        this.initial = initial;
    }

    public String getInitial() {
        return initial;
    }

    @Override
    public String toString() {
        return CommonUtil.capitalizeEnumName(name());
    }
}
package com.kshyk.common;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class DateUtil {
    private DateUtil() {
        // Util class
    }

    public static LocalDate getLastWorkingDayOfMonth(LocalDate date) {
        LocalDate lastWorkingDayOfMonth;
        switch (DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK))) {
            case SATURDAY -> lastWorkingDayOfMonth = date.minusDays(1);
            case SUNDAY -> lastWorkingDayOfMonth = date.minusDays(2);
            default -> lastWorkingDayOfMonth = date;
        }
        return lastWorkingDayOfMonth;
    }
}
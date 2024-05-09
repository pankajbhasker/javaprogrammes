package com.bhasker.programs.datebase;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateDifference {

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public static boolean isFederalHoliday(LocalDate date) {
        int year = date.getYear();
        // New Year's Day
        if (date.getMonth() == Month.JANUARY && date.getDayOfMonth() == 1)
            return true;
        // Martin Luther King Jr. Day (third Monday in January)
        if (date.getMonth() == Month.JANUARY && date.getDayOfWeek().getValue() == 1 && date.getDayOfMonth() > 14)
            return true;
        // Presidents' Day (third Monday in February)
        if (date.getMonth() == Month.FEBRUARY && date.getDayOfWeek().getValue() == 1 && date.getDayOfMonth() > 14)
            return true;
        // Memorial Day (last Monday in May)
        if (date.getMonth() == Month.MAY && date.getDayOfWeek().getValue() == 1 && date.getDayOfMonth() > 24)
            return true;
        // Independence Day
        if (date.getMonth() == Month.JULY && date.getDayOfMonth() == 4)
            return true;
        // Labor Day (first Monday in September)
        if (date.getMonth() == Month.SEPTEMBER && date.getDayOfWeek().getValue() == 1 && date.getDayOfMonth() < 8)
            return true;
        // Columbus Day (second Monday in October)
        if (date.getMonth() == Month.OCTOBER && date.getDayOfWeek().getValue() == 1 && date.getDayOfMonth() > 7 && date.getDayOfMonth() < 15)
            return true;
        // Veterans Day
        if (date.getMonth() == Month.NOVEMBER && date.getDayOfMonth() == 11)
            return true;
        // Thanksgiving Day (fourth Thursday in November)
        if (date.getMonth() == Month.NOVEMBER && date.getDayOfWeek().getValue() == 4 && date.getDayOfMonth() > 21 && date.getDayOfMonth() < 29)
            return true;
        // Christmas Day
        if (date.getMonth() == Month.DECEMBER && date.getDayOfMonth() == 25)
            return true;

        return false;
    }

    public static long getBusinessDays(LocalDate startDate, LocalDate endDate) {
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        long businessDays = 0;

        for (int i = 0; i < daysBetween; i++) {
            LocalDate currentDate = startDate.plusDays(i);
            if (!isWeekend(currentDate) && !isFederalHoliday(currentDate)) {
                businessDays++;
            }
        }

        return businessDays;
    }

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2023, Month.DECEMBER, 26); // Change to your start date
        LocalDate endDate = LocalDate.of(2024, Month.JANUARY, 15); // Change to your end date

        long businessDays = getBusinessDays(startDate, endDate);

        System.out.println("Number of business days between " + startDate + " and " + endDate + ": " + businessDays);
    }
}

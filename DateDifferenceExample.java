package com.bhasker.programs.datebase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateDifferenceExample {
    public static void main(String[] args) {

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("dd MMM yyyy")
                .toFormatter(Locale.ENGLISH);
        String startDateString = preprocessDateString("01 MAY 2024");
        String endDateString = preprocessDateString("10 JUNE 2024");

        try {
            LocalDate startDate = LocalDate.parse(startDateString, formatter);
            LocalDate endDate = LocalDate.parse(endDateString, formatter);

            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
            System.out.println("Days between: " + daysBetween);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static String preprocessDateString(String dateString) {
        String[] parts = dateString.split("\\s+");
        if (parts.length >= 2) {
            String monthBefore = parts[1];
            String monthAfter =  "";
            if(monthBefore.length() > 3){
                monthAfter = monthBefore.substring(0,3).toUpperCase();
                String date = dateString.replace(monthBefore, monthAfter.toUpperCase());
                return date;
            }
            String date = dateString.replace(monthBefore, monthBefore.toUpperCase());
            return date;
        }
        return dateString;
    }
}

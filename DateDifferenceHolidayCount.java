package com.bhasker.programs.datebase;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DateDifferenceHolidayCount {
  //  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("EEE MM/dd/yyyy");

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy");
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
    public static int countHolidays(List<String> dates) {
        int holidayCount = 0;

        for (String dateString : dates) {
            LocalDate date = LocalDate.parse(dateString, DATE_FORMATTER);

            if (isWeekend(date) || isFederalHoliday(date)) {
                holidayCount++;
            }
        }

        return holidayCount;
    }
    public static void main(String[] args) {
        // List of dates from June 8, 2024, to June 12, 2024
        List<String> dates1 = List.of(
                "Sat Jun 08 00:00:00 IST 2024", "Sun Jun 09 00:00:00 IST 2024", "Mon Jun 10 00:00:00 IST 2024",
                "Tue Jun 11 00:00:00 IST 2024", "Wed Jun 12 00:00:00 IST 2024"
        );

        // List of dates from June 9, 2024, to June 12, 2024
        List<String> dates2 = List.of(
                "Sun Jun 09 00:00:00 IST 2024", "Mon Jun 10 00:00:00 IST 2024",
                "Tue Jun 11 00:00:00 IST 2024", "Wed Jun 12 00:00:00 IST 2024"
        );

        // List of dates from June 10, 2024, to June 15, 2024
        List<String> dates3 = List.of(
                "Mon Jun 10 00:00:00 IST 2024", "Tue Jun 11 00:00:00 IST 2024", "Wed Jun 12 00:00:00 IST 2024",
                "Thu Jun 13 00:00:00 IST 2024", "Fri Jun 14 00:00:00 IST 2024", "Sat Jun 15 00:00:00 IST 2024"
        );

        int holidays1 = countHolidays(dates1);
        int holidays2 = countHolidays(dates2);
        int holidays3 = countHolidays(dates3);

        System.out.println("Number of holidays (including weekends and federal holidays) from June 8, 2024 to June 12, 2024: " + holidays1);
        System.out.println("Number of holidays (including weekends and federal holidays) from June 9, 2024 to June 12, 2024: " + holidays2);
        System.out.println("Number of holidays (including weekends and federal holidays) from June 10, 2024 to June 15, 2024: " + holidays3);
    }

    public static void main1(String[] args) {
        LocalDate startDate = LocalDate.of(2023, Month.DECEMBER, 26); // Change to your start date
        LocalDate endDate = LocalDate.of(2024, Month.JANUARY, 15); // Change to your end date

        long businessDays = getBusinessDays(startDate, endDate);

        System.out.println("Number of business days between " + startDate + " and " + endDate + ": " + businessDays);

        List<String> dates = List.of(
                "Mon May 20 00:00:00 IST 2024", "Tue May 21 00:00:00 IST 2024", "Wed May 22 00:00:00 IST 2024",
                "Thu May 23 00:00:00 IST 2024", "Fri May 24 00:00:00 IST 2024", "Sat May 25 00:00:00 IST 2024",
                "Sun May 26 00:00:00 IST 2024", "Mon May 27 00:00:00 IST 2024", "Tue May 28 00:00:00 IST 2024"
        );

        int holidays = countHolidays(dates);

        System.out.println("Number of holidays (including weekends and federal holidays): " + holidays);


        // List of dates from May 8, 2024, to May 12, 2024
        List<String> dates1 = List.of(
                "Wed May 08 00:00:00 IST 2024", "Thu May 09 00:00:00 IST 2024", "Fri May 10 00:00:00 IST 2024",
                "Sat May 11 00:00:00 IST 2024", "Sun May 12 00:00:00 IST 2024"
        );

        // List of dates from May 9, 2024, to May 12, 2024
        List<String> dates2 = List.of(
                "Thu May 09 00:00:00 IST 2024", "Fri May 10 00:00:00 IST 2024",
                "Sat May 11 00:00:00 IST 2024", "Sun May 12 00:00:00 IST 2024"
        );

        // List of dates from May 10, 2024, to May 15, 2024
        List<String> dates3 = List.of(
                "Fri May 10 00:00:00 IST 2024", "Sat May 11 00:00:00 IST 2024", "Sun May 12 00:00:00 IST 2024",
                "Mon May 13 00:00:00 IST 2024", "Tue May 14 00:00:00 IST 2024", "Wed May 15 00:00:00 IST 2024"
        );

        int holidays1 = countHolidays(dates1);
        int holidays2 = countHolidays(dates2);
        int holidays3 = countHolidays(dates3);

        System.out.println("Number of holidays (including weekends and federal holidays) from May 8, 2024 to May 12, 2024: " + holidays1);
        System.out.println("Number of holidays (including weekends and federal holidays) from May 9, 2024 to May 12, 2024: " + holidays2);
        System.out.println("Number of holidays (including weekends and federal holidays) from May 10, 2024 to May 15, 2024: " + holidays3);


    }
}

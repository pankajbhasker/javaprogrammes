package com.bhasker.app;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetNonHolidayDate {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

    public static Date findNextNonHolidayDate(Date someDay, List<Date> holidayList) {
        while (isHoliday(someDay, holidayList)) {
            someDay = addOneDay(someDay);
        }
        return someDay;
    }

    private static boolean isHoliday(Date date, List<Date> holidayList) {
        for (Date holiday : holidayList) {
            if (DATE_FORMATTER.format(date).equals(DATE_FORMATTER.format(holiday))) {
                return true;
            }
        }
        return false;
    }

    private static Date addOneDay(Date date) {
        long millisInDay = 24 * 60 * 60 * 1000;
        return new Date(date.getTime() + millisInDay);
    }

    public static void main(String[] args) throws ParseException {
        // Example usage
        String dateString = "Sat Jun 08 00:00:00 IST 2024";
        Date someDay = DATE_FORMATTER.parse(dateString);

        List<Date> holidayList = new ArrayList<>();
        holidayList.add(DATE_FORMATTER.parse("Sat Jun 08 00:00:00 IST 2024"));
        holidayList.add(DATE_FORMATTER.parse("Sun Jun 09 00:00:00 IST 2024"));
        holidayList.add(DATE_FORMATTER.parse("Mon Jun 20 00:00:00 IST 2024"));

        Date nextNonHolidayDate = findNextNonHolidayDate(someDay, holidayList);
        System.out.println("Next non-holiday date: " + DATE_FORMATTER.format(nextNonHolidayDate));
    }
}

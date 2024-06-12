package com.bhasker.programs.datebase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static void main(String[] args) {
        String dateString = "Sat Jun 08 00:00:00 IST 2024";
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

        try {
            Date date = formatter.parse(dateString);
            System.out.println("Date object: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

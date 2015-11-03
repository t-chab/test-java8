package com.java8.training.exercises.exercise5;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created on 02/11/2015.
 */

class MonthYear {
    public static void display(int year) {
        Year y = Year.of(year);
        for(Month m : Month.values()) {
            System.out.println("month=" + m.getDisplayName(TextStyle.FULL , Locale.FRANCE)
                    + " - length=" + m.length(y.isLeap()));
        }
    }
}

class ListMondays {

    public static void display(Month month, int year) {
        LocalDate firstDay = Year.of(year).atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        Month m = firstDay.getMonth();
        while(m.equals(month)) {
            System.out.println(firstDay);
            firstDay = firstDay.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            month = firstDay.getMonth();
        }
    }
}

class FridayThirteenQuery implements TemporalQuery<Boolean> {

    /**
     * @return true if date is a friday and the 13
     * */
    @Override
    public Boolean queryFrom(TemporalAccessor date) {
        return (date.get(ChronoField.DAY_OF_MONTH) == 13) && (date.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.FRIDAY.getValue());
    }
}

class Superstitious {
    public static boolean isDangerous(LocalDate date, TemporalQuery<Boolean> query) {
        return query.queryFrom(date);
    }
}

class Step2 {

    public static void main(String[] args) {
        System.out.println("Exercise5.Step2.main()");
        System.out.println("Type year as int :");
        Scanner read = new Scanner(System.in);
        int year = read.nextInt();
        MonthYear.display(year);
        
        System.out.println("Type month as int :");
        int month = read.nextInt();
        ListMondays.display(Month.of(month), Year.now().getValue());

        System.out.println("Type year as int :");
        int y = read.nextInt();

        System.out.println("Type month as int :");
        int m = read.nextInt();

        FridayThirteenQuery q = new FridayThirteenQuery();
        LocalDate dateFriday = LocalDate.of(y, m, 13);
        System.out.println(dateFriday + " is Friday, 13=" + Superstitious.isDangerous(dateFriday, q));

        // Sample conversion
        Date dateFromInstant = Date.from(Instant.now());
        System.out.println(dateFromInstant);
        Date dateToInstant = new Date();
        Instant i = dateToInstant.toInstant();
        System.out.println(i);

        read.close();
    }
}

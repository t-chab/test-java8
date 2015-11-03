package com.java8.training.exercises.exercise5;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * Created on 02/11/2015.
 */
class Step1 {

    public static void main(String [] args) {

        // Birthday
        LocalDate birthday = LocalDate.of(1970, Month.JANUARY, 1);
        LocalDate today = LocalDate.now();
        Period betweenDate = Period.between(birthday, today);
        int howOld = betweenDate.getYears();
        System.out.println("I am " + howOld);

        // Previous thursday from current date
        LocalDate random = LocalDate.ofEpochDay(Math.round(Math.random()*15500));
        LocalDate result = random.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
        System.out.println(random);
        System.out.println(result);

        // Instant to Zoned Date Time
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(zdt);
    }
}

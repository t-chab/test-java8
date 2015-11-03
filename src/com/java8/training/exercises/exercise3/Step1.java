package com.java8.training.exercises.exercise3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 03/11/2015.
 */
class Step1 {
    private final static String SEPARATOR = "------------------------------------------------------";

    private static String searchFor(Stream<String> st, String str) {
        return st.map(String::toUpperCase)
                .filter(s -> s.length() <= 4)
                .filter(t -> t.contains(str))
                .peek(System.out::println)
                .findFirst().orElse("");
    }

    public static void main(String[] args) {
        List<String> firstnames = Arrays.asList("Lisa", "Bart", "Maggie", "Marge", "Homer", "Apu", "Mandula");

        firstnames.stream().forEach(firstname -> System.out.printf("%s\n", firstname));
        firstnames.stream().forEach(System.out::println);
        List<String> result = firstnames.stream()
                .filter(firstname -> firstname.startsWith("M"))
                .peek(firstname -> System.out.printf("%s --\n", firstname))
                .collect(Collectors.toList());
        System.out.println(result);

        System.out.println(SEPARATOR);

        List<String> r1 = firstnames.stream().map(firstname -> firstname.concat("!")).collect(Collectors.toList());
        System.out.println(r1);
        List<String> r2 = firstnames.stream().map(firstname -> firstname.replace("ic", "ik")).collect(Collectors.toList());
        System.out.println(r2);
        List<String> r3 = firstnames.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(r3);

        System.out.println(SEPARATOR);

        String letter = "b";

        long c1 = firstnames.stream().filter(s -> s.length() <= 4).peek(System.out::println).count();
        System.out.println("Names lower than 4: " + c1);
        long c2 = firstnames.stream().filter(s -> s.toLowerCase().contains(letter)).peek(System.out::println).count();
        System.out.println("Names that contains a b: " + c2);
        long c3 = firstnames.stream().filter(s -> (s.length() % 2) == 0).peek(System.out::println).count();
        System.out.println("Names that length is multiple of 2: " + c3);

        System.out.println(SEPARATOR);

        firstnames.stream().map(String::toUpperCase)
                .filter(s -> s.length() <= 4)
                .filter(t -> t.contains(letter))
                .peek(System.out::println)
                .findFirst();

        System.out.println(SEPARATOR);

        System.out.println(searchFor(firstnames.stream(), letter));
        System.out.println(searchFor(firstnames.stream(), "E"));
    }
}

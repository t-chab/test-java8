package com.java8.training.exercises.exercise3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 03/11/2015.
 */
class StreamUtils {
    public static List<Double> randomNumberList(int size) {
        return Stream.generate(Math::random)
                .limit(size)
                .collect(Collectors.toList());
    }

    public static List<Integer> orderedNumberList(int start, int step, int size) {
        return Stream.iterate(start, (i) -> i + step)
                .limit(size)
                .collect(Collectors.toList());
    }

}

class Step2 {

    public static void main(String[] args) {
        String[] firstnames = {"Homer", "Lisa", "Marge", "Bart"};

        String result = Arrays.stream(firstnames).reduce("", (s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase());
        System.out.println(result);

        String result2 = Arrays.stream(firstnames).map(String::toUpperCase).reduce("", (s1, s2) -> s1.concat(" " + s2));
        System.out.println(result2);

        String result3 = Arrays.stream(firstnames).map(String::toUpperCase).reduce((s1, s2) -> s1.concat(", " + s2)).orElse("");
        System.out.println(result3);

        String result4 = Arrays.stream(firstnames).collect(Collectors.joining(","));
        System.out.println(result4);

        int n = 65;
        System.out.println("List of " + n + " random numbers");
        System.out.println(StreamUtils.randomNumberList(n));

        int start = 25;
        int step = 5;
        int size = 20;
        System.out.println("List of " + size + " numbers from " + start + " with " + step + " increments.");
        System.out.println(StreamUtils.orderedNumberList(start, step, size));

        System.out.println("Total number of letters : ");
        System.out.println(Arrays.stream(firstnames).map(String::length).reduce(0, Integer::sum));
    }
}

package com.java8.training.exercises.exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created on 03/11/2015.
 */

class FunctionUtils {
    @SafeVarargs
    public static <T> Predicate<T> allPassPredicates(Predicate<T> ... predicates) {
        Predicate<T> result = (t) -> true;
        for(Predicate<T> p : predicates)  {
            result = p.and(result);
        }
        return result;
    }

    @SafeVarargs
    public static <T> Predicate<T> anyPassPredicates(Predicate<T>... predicates) {
        Predicate<T> result = (t) -> true;
        for (Predicate<T> p : predicates) {
            result = p.or(result);
        }
        return result;
    }

    @SafeVarargs
    public static <T> T firstAllMatch(Stream<T> stream, Predicate<T> ... predicates) {
        Predicate<T> conjunction = allPassPredicates(predicates);
        return stream.filter(conjunction).findFirst().orElse(null);
    }

    @SafeVarargs
    public static <T> T firstAnyMatch(Stream<T> stream, Predicate<T>... predicates) {
        Predicate<T> conjunction = anyPassPredicates(predicates);
        return stream.filter(conjunction).findFirst().orElse(null);
    }
}

class Step6 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("one", "elephant", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "blob", "parrot", "olofolous");

        System.out.println("Words: " + words);
        System.out.println("First word containing 'o' and longer than 5: " + FunctionUtils.firstAllMatch(words.stream(),
                s -> s.contains("o"), s -> s.length() > 5));

        System.out.println("First word containing 'o' or longer than 5: " + FunctionUtils.firstAnyMatch(words.stream(),
                s -> s.contains("o"), s -> s.length() > 5));

    }
}

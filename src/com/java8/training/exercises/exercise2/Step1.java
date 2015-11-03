package com.java8.training.exercises.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface TwoStringPredicate {
    boolean isBetter(final String first, final String second);
}

@FunctionalInterface
interface MatchingPredicate {
    boolean match(final String str);
}


class StringUtils {
    public static String betterString(final String first, final String second, TwoStringPredicate predicate) {
        return predicate.isBetter(first,second) ? first : second ;
    }

    public static int eChecker(final String s1, final String s2){
        return s1.toLowerCase().contains("e") && !s2.toLowerCase().contains("e") ? -1 : 1;
    }

    public static List<String> allMatches(List<String> words, MatchingPredicate predicate) {
        List<String> lList = new ArrayList<>();
        for(String w : words) {
            if(predicate.match(w)) {
                lList.add(w);
            }
        }
        return  lList;
    }
}

/**
 * Created on 03/11/2015.
 */
public class Step1 {

    public static void main(String[] args) {
        String[] strArray = {"Nicolas", "Thierry", "Jaouad", "Thomas", "Eric", "Thierry", "Philippe"};

        final List arrayAsList = Arrays.asList(strArray);

        // Sample Array
        System.out.println(arrayAsList);

        // Sort by length
        Arrays.sort(strArray, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.asList(strArray));

        // Inverted sort
        Arrays.sort(strArray, (s1, s2) -> s2.length() - s1.length());
        System.out.println(Arrays.asList(strArray));

        // Alphabetical sort
        Arrays.sort(strArray, (s1, s2) -> s2.charAt(0) - s1.charAt(0));
        System.out.println(Arrays.asList(strArray));

        // str with 'e' before others
        Arrays.sort(strArray, (s1, s2) -> s1.toLowerCase().contains("e") && !s2.toLowerCase().contains("e") ? -1 : 1);
        System.out.println(Arrays.asList(strArray));

        // Same thing with method reference
        Arrays.sort(strArray, StringUtils::eChecker);
        System.out.println(Arrays.asList(strArray));

        // Better is longer
        final String first = "IamTheLongest";
        final String second = "short";
        System.out.println("First string is " + first + " - second is " + second);

        final String longest = StringUtils.betterString(first, second, (s1, s2) -> s1.length() > s2.length());
        System.out.println("The Longest is " + longest);

        // Alphabetical order
        final String alphabetical = StringUtils.betterString(first, second, (s1, s2) -> s1.charAt(0) < s2.charAt(0));
        System.out.println("First string in alphabetical sort is " + alphabetical);


    }
}

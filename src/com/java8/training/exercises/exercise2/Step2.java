package com.java8.training.exercises.exercise2;

/**
 * Created on 03/11/2015.
 */
public class Step2 {

    public static void main(String[] args) {

        // Better is longer
        final String first = "zIamTheLongest";
        final String second = "short";
        System.out.println("First string is " + first + " - second is " + second);

        final String longest = StringUtils.betterString(first, second, (s1, s2) -> s1.length() > s2.length());
        System.out.println("The Longest is " + longest);

        // Alphabetical order
        final String alphabetical = StringUtils.betterString(first, second, (s1, s2) -> s1.charAt(0) < s2.charAt(0));
        System.out.println("First string in alphabetical sort is " + alphabetical);

    }
}

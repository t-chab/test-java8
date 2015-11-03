package com.java8.training.exercises.exercise2;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 03/11/2015.
 */
class Step5 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "blob", "parrot", "elephant");
        System.out.println("Words list: " + words);
        List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
        System.out.println("Add ! to each word: " + excitingWords);
        List<String> eyeWords = StringUtils.transformedList(words, s ->  s.replace("e", "a"));
        System.out.println("Replaced e by a: " + eyeWords);
        List<String> upperCaseWords = StringUtils.transformedList(words,
                String::toUpperCase);
        System.out.println("Words uppercased: " + upperCaseWords);

        List<Integer> wordLengths = ElementUtils.transformedList(words,
                String::length);
        System.out.println("Words length: " + wordLengths);
    }
}

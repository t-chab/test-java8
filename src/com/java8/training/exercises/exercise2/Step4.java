package com.java8.training.exercises.exercise2;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 03/11/2015.
 */
public class Step4 {

    public static void main(String[] args) {

    List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "blob");

    int size = 4;
    List<String> shortWords = StringUtils.allMatches(words, s -> s.length() <= size);
    System.out.println("Words shorter than " + size + ": " + shortWords);

    final String letter = "b";
    List<String> wordsWithLetter = StringUtils.allMatches(words, s -> s.contains(letter));
    System.out.println("Words that contains " + letter + ": " + wordsWithLetter);

    List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length()
        % 2) == 0);
    System.out.println("Even length words : " + evenLengthWords);

    List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
    System.out.println("Nums : " + nums);
    List<Integer> bigNums = ElementUtils.allMatches(nums, n -> n>500);
    System.out.println("Big Nums : " + bigNums);
}
}

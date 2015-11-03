package com.java8.training.exercises.exercise1;

import java.util.Arrays;

public class Step1 {

    private final Runnable r = () -> System.out.println("Hello world");

    public static void main(String args[]) {
        System.out.println("exercise1.Step1.main()");

        Step1 e1 = new Step1();

        e1.r.run();

        final String[] strString = {"Nicolas", "Thierry", "Jaouad", "Thomas", "Eric", "Thierry", "Philippe"};

        Arrays.sort(strString, (p1, p2) -> p1.length() - p2.length());
        for (String str : strString) {
            System.out.println(str);
        }
    }

    @Override
    public String toString() {
        return "Step1 toString()";
    }
}

package com.java8.training.exercises.exercise1;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 02/11/2015.
 */

@FunctionalInterface
interface Formatter {
    String format(String fmt, Object... args);
}

class Plop implements Formatter {
    public String format(String fmt, Object... args) {
        return String.format(fmt, args);
    }
}

public class Step3 {
    public static void main(String[] args) {
        final String[] strString = {"Nicolas", "Thierry", "Jaouad", "Thomas", "Eric", "Thierry", "Philippe"};

        final List<String> list = Arrays.asList(strString);

        forEach(list, String::format);

        forEach(list, (fmt, obj) -> String.format(fmt, obj));

        // Also works with instances method, not only classes method
        Plop p = new Plop();
        forEach(list, p::format);
        Arrays.asList(strString);
    }

    static void forEach(final List<String> list, Formatter f) {
        for (String s : list) {
            System.out.println(f.format("\t%s\n", s));
        }
    }


}

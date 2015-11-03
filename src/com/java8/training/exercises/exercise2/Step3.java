package com.java8.training.exercises.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface TwoElementPredicate<T> {
    boolean isBetterEntry(final T firstEntry, final T secondEntry);
}

@FunctionalInterface
interface GenericPredicate<T> {
    boolean match(final T str);
}

class ElementUtils {
    public static <T> T betterElement(final T firstEntry, final T secondEntry, TwoElementPredicate<T> predicate) {
        return predicate.isBetterEntry(firstEntry, secondEntry) ? firstEntry : secondEntry;
    }

    public static <T> List<T> allMatches(final List<T> input, GenericPredicate<T> predicate) {
        List<T> lList = new ArrayList<>();
        for(T element : input) {
            if(predicate.match(element)) {
                lList.add(element);
            }
        }
        return  lList;
    }

    public static <T, R> List<R> transformedList(List<T> elements, Function<T, R> f) {
        List<R> lList = new ArrayList<>();
        for(T element : elements) {
            R result = f.apply(element);
            lList.add(result);
        }
        return lList;
    }
}

class Car {
    private String name;
    private float price;

    public Car(String pName, float pPrice) {
        name = pName;
        price = pPrice;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        return this.getName() + " - " + this.getPrice();

    }
}

/**
 * Created on 03/11/2015.
 */
public class Step3 {

    public static void main(String[] args) {
        Car car1 = new Car("VW Polo", 2000);
        Car car2 = new Car("Ford Escort", 6000);
        System.out.println(ElementUtils.betterElement(car1, car2, (c1, c2) -> c1.getPrice() > c2.getPrice()));
    }
}

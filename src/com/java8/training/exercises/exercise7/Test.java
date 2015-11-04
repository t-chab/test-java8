package com.java8.training.exercises.exercise7;

import java.util.ArrayList;
import java.util.Set;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 04/11/2015.
 */

class Employee {
    final private String name;
    final private double wage;

    Employee(String name, double wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public double getWage() {
        return wage;
    }
}

class Enterprise extends ArrayList<Employee> {
    private final String name;

    public Enterprise(String nom) {
        this.name = nom;
    }

    public String getName() {
        return name;
    }

    public void add(Employee... emp) {
        Set<Employee> s = Stream.of(emp)
                .filter(e -> !this.contains(e))
                .collect(Collectors.toSet());
        this.addAll(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        for (Employee employe : this) {
            sb.append("\n ").append(employe.getName());
        }
        return sb.toString();
    }
}

public class Test {

    private static ToDoubleFunction<Double> add(Integer i) {
        return x -> x + i;
    }

    public static void main(String[] args) {
        final Enterprise company = new Enterprise("Acme");
        company.add(new Employee("Bart", 5000), new Employee("Homer", 6000), new Employee("Marge", 5700), new Employee("Apu", 4300));
        System.out.println(company.getName());

        long i = company.stream()
                .sorted((emp1, emp2) -> Double.compare(emp1.getWage(), emp2.getWage()))
                .peek(e -> System.out.println(e.getName() + " wins " + e.getWage()))
                .count();
        System.out.println("Total number of employees : " + i);

        ToDoubleFunction<Double> add100 = add(100);
        company.stream()
                .map(Employee::getWage)
                .map(add100::applyAsDouble)
                .forEach(System.out::println);
    }
}

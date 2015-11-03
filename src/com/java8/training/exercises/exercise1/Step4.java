package com.java8.training.exercises.exercise1;

import java.util.function.Supplier;

interface Defaultable {
    default String notRequired() {
        return "Defaultable::notRequired()";
    }
}

/**
 * Created by 02/11/2015.
 */
public class Step4 {

    public static void main(String args[]) {
        System.out.println("exercise1.Step4.main()");
        Defaultable dl = DefaultableFactory.create(DefaultableImpl::new);
        System.out.println(dl.notRequired());
        Defaultable d2 = DefaultableFactory.create(OverridableImpl::new);
        System.out.println(d2.notRequired());
    }
}

class DefaultableImpl implements Defaultable {
}

class OverridableImpl implements Defaultable {
    @Override
    public String notRequired() {
        return "OverridableImpl::notRequired()";
    }
}

class DefaultableFactory {
    public static Defaultable create(Supplier<Defaultable> method) {
        return method.get();
    }
}

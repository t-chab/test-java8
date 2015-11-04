function sum(a, b) {
    return a + b;
}

function javaCall() {
    var Step1 = Java.type("com.java8.training.exercises.exercise6.Step1");
    var step1 = new Step1();
    return step1.callMeFromJs();
}

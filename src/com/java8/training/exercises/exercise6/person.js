/**
 * person.js
 */

 function Person(firstname, lastname, age) {
     this.first = firstname;
     this.last = lastname;
     this.age = age;
     this.getInfo = function() {
        return this.first + " " + this.last + " " + this.age;
     }
 }

var java = Packages.java;
var env = Packages.com.java8.training.exercises.exercise6;
var Step1 = env.Step1;

var step1 = new Step1();
var jd = new Person("John", "Doe", 42);
step1.transfer(jd);

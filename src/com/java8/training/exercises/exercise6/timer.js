/**
 * timer.js
 */

var java = Packages.java;
var env = Packages.com.java8.training.exercises.exercise6;
var TimerTask = java.util.TimerTask;
var Timer = java.util.Timer;
var Thread = java.lang.Thread;
var Step1 = env.Step1;

var task = new TimerTask() {
    run: function() {
       var step1 = new Step1();
       print(step1.callMeFromJs());
    }
}

var timer  = new Timer();
timer.schedule(task, 0, 1000);
Thread.sleep(10000);
task.cancel();
timer.cancel();

package com.java8.training.exercises.exercise6;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created on 04/11/2015.
 */
public class Step1 {
    public static String nashornString(final String jsFile, String funcName, Object... params) throws FileNotFoundException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        Object result = null;
        try {
            //            final Object result = engine.eval("10 + 5");
            engine.eval(new BufferedReader(new InputStreamReader(Step1.class.getClassLoader().getResourceAsStream(
                    jsFile))));
            final Invocable inv = (Invocable) engine;
            result = (funcName == null || funcName.trim().equals("")) ? "" : inv.invokeFunction(funcName, params);
        } catch (ScriptException e) {
            System.err.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            System.err.println(e.getMessage());
        }
        return "js function result: " + result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("exercise6.Step1.main");
        System.out.println(nashornString("com/java8/training/exercises/exercise6/simple.js", "sum", 42, 1337));
        System.out.println(nashornString("com/java8/training/exercises/exercise6/timer.js", null));
    }

    public String callMeFromJs() {
        final LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss dd/MM/yyyy");
        String formattedTime = formatter.format(time);
        return "I am a Java method called from JS interpreter at " + formattedTime;
    }
}

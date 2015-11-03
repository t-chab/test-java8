package com.java8.training.exercises.exercise1;

/**
 * Created on 02/11/2015.
 */
class Step2 {

    public static void main(String args[]) {
        System.out.println("exercise1.Step2.main()");
        Thread t = new Thread(Step2::doWork, "first thread");
        t.start();

        System.out.println("-------------------------------------------");
        Thread t2 = new Thread(() -> doWork(), "second thread");
        t2.start();
        System.out.println("-------------------------------------------");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        }, "third thread");
        t3.start();
    }

    static void doWork() {
        final String name = Thread.currentThread().getName();
        for (int i = 0; i < 50; i++) {
            System.out.println(name);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

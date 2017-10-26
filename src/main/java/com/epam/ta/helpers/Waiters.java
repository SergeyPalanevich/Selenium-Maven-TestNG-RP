package com.epam.ta.helpers;

public class Waiters {
    public static void doSleep(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

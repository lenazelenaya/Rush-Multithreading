package com.javarush.task.task28.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* 
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(() -> doExpensiveOperation(localId));
        }

        List<Runnable> runnableList =  executor.shutdownNow();
        for (Runnable runnable : runnableList) {
            System.out.println(runnable + "  was not completed");
        }

    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

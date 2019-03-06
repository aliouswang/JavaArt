package com.aliouswang.olympic.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    public AtomicInteger atomicInteger = new AtomicInteger(0);
    public int i = 0;

    public static void main(String[] args) {
        final Counter counter = new Counter();
        List<Thread> threadList = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        counter.count();
                        counter.safeCount();
                    }
                }
            });
            threadList.add(t);
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("count:" + counter.i);
        System.out.println("safe count:" + counter.atomicInteger.get());
    }

    public void count() {
        i++;
    }

    public void safeCount() {
//        for (;;) {
//            int i = atomicInteger.get();
//            boolean result = atomicInteger.compareAndSet(i, ++i);
//            if (result) break;
//        }
        atomicInteger.getAndIncrement();
    }

}

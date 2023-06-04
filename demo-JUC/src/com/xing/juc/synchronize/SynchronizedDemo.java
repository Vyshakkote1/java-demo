package com.xing.juc.synchronize;

/**
 * @author: Xingweicheng
 * @description: 锁原理
 * **synchronized: 具有原子性，有序性和可见性**；
 * **volatile：具有有序性和可见性**
 * @date: 2022/11/30 19:43
 */
public class SynchronizedDemo implements Runnable {
    private static  int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        synchronized (SynchronizedDemo.class) {
            for (int i = 0; i < 1000000; i++)
                count++;
        }
    }
}

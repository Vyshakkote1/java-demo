package com.xing.juc.synchronize;

/**
 * @author: Xingweicheng
 * @description: volatile关键字
 * @date: 2022/11/30 19:57
 */
public class VolatileDemo {
    private static volatile boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                    System.out.println("卡住了");
                }
                System.out.println("出来了");
            }

        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}

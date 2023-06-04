package com.xing.juc.ticket;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Xingweicheng
 * @description: 测试
 * @date: 2023/4/6 10:49
 */
public class Test {

    public static int num = 50;

    public static Object lock = new Object();

    public static void main(String[] args) {
        Win1 win1 = new Win1();
        Win2 win2 = new Win2();
        win1.start();
        win2.start();
//        ExecutorService executorService = Executors.newFixedThreadPool(10,20);
    }
}

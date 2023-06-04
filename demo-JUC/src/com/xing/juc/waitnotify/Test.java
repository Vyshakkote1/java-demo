package com.xing.juc.waitnotify;

/**
 * @author: Xingweicheng
 * @description: TODO
 * @date: 2023/4/6 10:21
 */
public class Test {
    public static void main(String[] args) {
        Cooker cooker = new Cooker();
        Fooder fooder = new Fooder();
        cooker.start();
        fooder.start();
    }
}

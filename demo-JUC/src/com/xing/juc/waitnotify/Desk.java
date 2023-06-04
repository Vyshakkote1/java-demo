package com.xing.juc.waitnotify;

/**
 * @author: Xingweicheng
 * @description: TODO
 * @date: 2023/4/6 9:29
 */
public class Desk {

    //互斥变量
    public static boolean flag = false;//一开始桌子上没有

    //锁对象
    public static Object lock = new Object();

    //吃货最多吃多少碗面条
    public static int max = 10;


}

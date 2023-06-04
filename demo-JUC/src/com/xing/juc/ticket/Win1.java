package com.xing.juc.ticket;

/**
 * @author: Xingweicheng
 * @description: 窗口一
 * @date: 2023/4/6 10:47
 */
public class Win1 extends Thread{


    @Override
    public void run() {
        while(Test.num > 0) {
            synchronized (Test.lock) {
                Test.num--;
                System.out.println("窗口一售卖出，还剩" + Test.num);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

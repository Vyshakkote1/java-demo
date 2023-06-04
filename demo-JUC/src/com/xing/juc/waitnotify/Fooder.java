package com.xing.juc.waitnotify;

/**
 * @author: Xingweicheng
 * @description: 吃货
 * @date: 2023/4/6 9:29
 */
public class Fooder extends Thread{


    @Override
    public void run() {
        while(true){
            synchronized (Desk.lock){
                if(Desk.flag){
                    Desk.max--;
                    System.out.println("吃了一碗面，还能吃"+Desk.max+"碗面条");
                    Desk.flag = false;
                    Desk.lock.notifyAll();
                    if(Desk.max == 0)
                        break;
                }else{
                    try {
                        Desk.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

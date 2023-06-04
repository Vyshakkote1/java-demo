package com.xing.juc.waitnotify;

/**
 * @author: Xingweicheng
 * @description: 厨师
 * @date: 2023/4/6 9:28
 */
public class Cooker extends Thread{

    @Override
    public void run() {
        while(true){
            synchronized (Desk.lock){
                if (!Desk.flag){
                    if(Desk.max == 0)
                        break;
                    System.out.println("厨师做了一碗面条");
                    Desk.flag = true;
                    Desk.lock.notifyAll();
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

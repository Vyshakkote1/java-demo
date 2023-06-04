package com.xing.juc.thread;

/**
 * @author: Xingweicheng
 * @description: 守护线程
 * 在后台默默地守护一些系统服务，比如垃圾回收线程，JIT线程就可以理解守护线程。
 * 与之对应的就是用户线程，用户线程就可以认为是系统的工作线程，它会完成整个系统的业务操作。
 * 用户线程完全结束后就意味着整个系统的业务任务全部结束了，因此系统就没有对象需要守护的了，守护线程自然而然就会退。
 * 当一个Java应用，只有守护线程的时候，虚拟机就会自然退出。
 * @date: 2022/11/30 18:57
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("i am alive");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("finally block");
                    // 守护线程在退出的时候并不会执行finnaly块中的代码，
                        // 所以将释放资源等操作不要放在finnaly块中执行，这种操作是不安全的
                    }
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        //确保main线程结束前能给daemonThread能够分到时间片
        // 主线程结束，守护线程结束
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

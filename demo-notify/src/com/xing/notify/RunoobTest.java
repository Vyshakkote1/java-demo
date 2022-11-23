package com.xing.notify;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xingweicheng
 * @description: native 方法，并且不能重写。唤醒一个在此对象监视器上等待的线程(监视器相当于就是锁的概念)。
 * 如果有多个线程在等待只会任意唤醒一个。
 * notify方法实例
 * Collections.synchronizedList实现同步的一种方式
 * @date: 2022/11/23 15:45
 */


public class RunoobTest {

    private List synchedList;

    public RunoobTest() {
        // 创建一个同步列表
        synchedList = Collections.synchronizedList(new LinkedList());
    }

    // 删除列表中的元素
    public String removeElement() throws InterruptedException {
        synchronized (synchedList) {

            // 列表为空就等待
            while (synchedList.isEmpty()) {
                System.out.println("List is empty...");
                synchedList.wait();//释放锁
                System.out.println("Waiting...");
            }
            String element = (String) synchedList.remove(0);
            return element;
        }
    }


    // 添加元素到列表
    public void addElement(String element) {
        System.out.println("Opening...");
        synchronized (synchedList) {

            // 添加一个元素，并通知元素已存在
            synchedList.add(element);
            System.out.println("New Element:'" + element + "'");

            synchedList.notifyAll();//唤醒线程
            System.out.println("notifyAll called!");
        }
        System.out.println("Closing...");
    }

    public static void main(String[] args) {
        final RunoobTest demo = new RunoobTest();

        Runnable runA = new Runnable() {

            public void run() {
                try {
                    String item = demo.removeElement();
                    System.out.println("" + item);
                } catch (InterruptedException ix) {
                    System.out.println("Interrupted Exception!");
                } catch (Exception x) {
                    System.out.println("Exception thrown.");
                }
            }
        };

        Runnable runB = new Runnable() {

            // 执行添加元素操作，并开始循环
            public void run() {
                demo.addElement("Hello!");
            }
        };
        try {
            Thread threadA1 = new Thread(runA, "Google");
            threadA1.start();
            Thread.sleep(500);
            Thread threadA2 = new Thread(runA, "Runoob");
            threadA2.start();
            Thread.sleep(500);
            Thread threadB = new Thread(runB, "Taobao");
            threadB.start();
            Thread.sleep(1000);
            threadA1.interrupt();
            threadA2.interrupt();
        } catch (InterruptedException x) {
        }
    }
}
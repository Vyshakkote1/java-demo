package com.xing.notify;

/**
 * @author: Xingweicheng
 * @description: 采用new创建的字符串进入常量池，从运行结果上来看
 * @date: 2022/11/23 21:08
 */
public class StringTest {
    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println(b.intern() == a);//false
        System.out.println(b.intern() == c);//true
        System.out.println(b.intern() == d);//true,字符串相加的时候，都是静态字符串的结果会添加到字符串池
        System.out.println(b.intern() == f);//false如果其中含有变量（如f中的e）则不会进入字符串池中。
        System.out.println(b.intern() == a.intern());//true
    }
}

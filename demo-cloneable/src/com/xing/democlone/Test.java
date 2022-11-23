package com.xing.democlone;

/**
 * @author: Xingweicheng
 * @description: TODO
 * @date: 2022/11/23 15:02
 */
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person(new Address("武汉"));
        Person person1Copy = person1.clone();
//        无论深拷贝还是浅拷贝，两个对象都是不同的
        System.out.println(person1==person1Copy);
        System.out.println(person1.getAddress() == person1Copy.getAddress());//浅拷贝，是一个对象

    }
}

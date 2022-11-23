package com.xing.democlone;

/**
 * @author: Xingweicheng
 * @description: 深拷贝与浅拷贝
 * 浅拷贝会在原来的堆栈上创建一个新的对象，不过如果内部属性如果是引用类型的话，浅拷贝直接复制内部对象的引用地址，也就是拷贝对象和源对象公用一个内部对象
 * 深拷贝会完全复制整个对象，包括对象内部所包含的内部对象
 * 引用拷贝就是在复制一份对象的别名，不会创建对象
 * @date: 2022/11/23 15:00
 */
public class Person implements Cloneable {
    private Address address;

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Person(Address address) {
        this.address = address;
    }

    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
//            深拷贝代码
//            person.setAddress(person.getAddress().clone());

            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

package com.xing.singleton;

/**
 * 测试线程安全型的懒加载单例模式
 */
public class ThreadSafeLazyLoadDirectorTest extends SingletonTest<ThreadSafeLazyLoadDirector> {

    /**
     * 创建一个测试用例
     */
    public ThreadSafeLazyLoadDirectorTest() {
        super(ThreadSafeLazyLoadDirector::getInstance);
    }
}
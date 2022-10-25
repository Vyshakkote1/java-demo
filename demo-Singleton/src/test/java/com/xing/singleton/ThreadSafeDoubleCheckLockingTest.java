package com.xing.singleton;

/**
 * 测试线程安全的双检锁单例模式
 */
public class ThreadSafeDoubleCheckLockingTest extends SingletonTest<ThreadSafeDoubleCheckLocking> {

    /**
     * 创建一个测试用例
     */
    public ThreadSafeDoubleCheckLockingTest() {
        super(ThreadSafeDoubleCheckLocking::getInstance);
    }
}

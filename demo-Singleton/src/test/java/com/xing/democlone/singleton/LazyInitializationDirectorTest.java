package com.xing.democlone.singleton;

/**
 * 测试懒加载型单例模式
 */
public class LazyInitializationDirectorTest extends SingletonTest<LazyInitializationDirector> {

    /**
     * 创建一个测试用例
     */
    public LazyInitializationDirectorTest() {
        super(LazyInitializationDirector::getInstance);
    }
}


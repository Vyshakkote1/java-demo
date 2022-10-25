package com.xing.singleton;

import junit.framework.TestCase;

public class DirectorTest extends  SingletonTest<Director> {
    /**
     * 创建一个测试用例
     */
    public DirectorTest() {
        super(Director::getInstance);
    }

}
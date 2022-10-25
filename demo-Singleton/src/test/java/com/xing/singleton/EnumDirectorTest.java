package com.xing.singleton;

import junit.framework.TestCase;

public class EnumDirectorTest extends SingletonTest<EnumDirector> {
    /**
     * 创建一个测试用例
     */
    public EnumDirectorTest() {
        super(() -> EnumDirector.INSTANCE);
    }

}
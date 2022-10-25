package com.xing.singleton;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Application {
    /**
     * Singleton
     */


            private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);



            public static void main(String[] args) {

                // “饿汉式” 单例模式
                Director director1 = Director.getInstance();
                Director director2 = Director.getInstance();
                LOGGER.info("饿汉式单例1 = {}", director1);
                LOGGER.info("饿汉式单例2 = {}", director2);

                // “懒汉式” 单例模式
                LazyInitializationDirector lazyDirector1 = LazyInitializationDirector.getInstance();
                LazyInitializationDirector lazyDirector2 = LazyInitializationDirector.getInstance();
                LOGGER.info("懒汉式单例1 = {}", lazyDirector1);
                LOGGER.info("懒汉式单例2 = {}", lazyDirector2);

                // 双检锁
                ThreadSafeDoubleCheckLocking doubleCheckLocking1 = ThreadSafeDoubleCheckLocking.getInstance();
                LOGGER.info("双检锁单例1 = {}", doubleCheckLocking1);
                ThreadSafeDoubleCheckLocking doubleCheckLocking2 = ThreadSafeDoubleCheckLocking.getInstance();
                LOGGER.info("双检锁单例2 = {}", doubleCheckLocking2);

                // 线程安全的“懒汉式” 单例模式
                ThreadSafeLazyLoadDirector lazyLoadDirector1 = ThreadSafeLazyLoadDirector.getInstance();
                LOGGER.info("线程安全的懒汉式单例1 = {}", lazyLoadDirector1.toString());
                ThreadSafeLazyLoadDirector lazyLoadDirector2 = ThreadSafeLazyLoadDirector.getInstance();
                LOGGER.info("线程安全的懒汉式单例2 = {}", lazyLoadDirector2.toString());

                // 枚举型的单例模式
                EnumDirector enumDirector1 = EnumDirector.INSTANCE;
                LOGGER.info("枚举型单例1 = {}", enumDirector1);
                EnumDirector enumDirector2 = EnumDirector.INSTANCE;
                LOGGER.info("枚举型单例2 = {}", enumDirector2);
        }
    }



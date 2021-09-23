package com.song.springboot.设计模式;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.9.23 9:01
 */
public class 单例模式 {
    private static 单例模式 线程安全单例 = null;
    private volatile static 单例模式 双检锁_双重校验锁;
    private static 单例模式 饿汉式 = new 单例模式();
    
    /**
     * 线程安全单例
     * @params :
     * @returns :
     */
    public static synchronized 单例模式 get线程安全单例() {
            if (线程安全单例 == null) {
                线程安全单例 = new 单例模式();
            }
        return 线程安全单例;
    }

    /**
     * 双检锁/双重校验锁（DCL，即 double-checked locking）
     * @params :
     * @returns :
     */
    public static 单例模式 get双检锁双重校验锁() {
        if (双检锁_双重校验锁 == null) {
            synchronized (单例模式.class) {
                if (双检锁_双重校验锁 == null) {
                    双检锁_双重校验锁 = new 单例模式();
                }
            }
        }
        return 双检锁_双重校验锁;
    }

    /**
     * 饿汉式，非 lazy loading
     * @params :
     * @returns :
     */
    public static 单例模式 get饿汉式() {
        return 饿汉式;
    }

    /**
     * 登记式/静态内部类
     * @params :
     * @returns :
     */
    private static class SingletonHolder {
        private static final 单例模式 登记式_静态内部类 = new 单例模式();
    }
    public static final 单例模式 getInstance4() {
        return SingletonHolder.登记式_静态内部类;
    }

    /**
     * 枚举
     * @params :
     * @returns :
     */
    public enum Singleton {
        INSTANCE;
        public void whateverMethod() {
        }
    }

    /**
     * 私密空参数构造函数
     * @params :
     * @returns :
     */
    private 单例模式 () {}
}

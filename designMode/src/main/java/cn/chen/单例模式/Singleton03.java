package cn.chen.单例模式;

/**
 * 饿汉式
 * 是否Lazy初始化：否
 * 是否多线程：是
 *
 * 描述：比较常用，但容易产生垃圾对象
 * 优点：没有加锁，执行效率提高
 * 缺点：类加载时就初始化，浪费内存
 */
public class Singleton03 {
    private static Singleton03 instance = new Singleton03();

    private Singleton03(){}

    public static Singleton03 getInstance(){
        return instance;
    }
}

package cn.chen.单例模式;

/**
 * 懒汉式，线程安全
 * 是否Lazy初始化：是
 * 是否多线程：是
 *
 * 优点：第一次调用才初始化，避免内存浪费
 * 缺点：必须加锁synchronized才能保证单例，但加锁会影响效率
 */
public class Singleton02 {
    private static Singleton02 instance;

    private Singleton02(){}

    public static synchronized Singleton02 getInstance(){
        if (instance == null){
            instance = new Singleton02();
        }
        return instance;
    }
}

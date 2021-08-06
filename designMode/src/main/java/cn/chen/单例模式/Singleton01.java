package cn.chen.单例模式;

/**
 * 懒汉式，线程不安全
 * 是否Lazy初始化：是
 * 是否多线程：否
 *
 * 描述：最基本的实现方式，不支持多线程
 */
public class Singleton01 {
    private static Singleton01 instance;

    private Singleton01(){}

    public static Singleton01 getInstance(){
        if (instance == null){
            instance = new Singleton01();
        }
        return instance;
    }
}

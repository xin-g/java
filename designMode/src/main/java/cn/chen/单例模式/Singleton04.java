package cn.chen.单例模式;

/**
 * 双检锁/双重校验锁（DCL，即double-checked locking)
 * 是否Lazy初始化：是
 * 是否多线程：是
 *
 * 描述：采用双锁机制，安全且在多线程情况下能保持高性能
 */
public class Singleton04 {
    private volatile static Singleton04 singleton;

    private Singleton04(){}

    public static Singleton04 getSingleton04(){
        if(singleton == null){
            synchronized (Singleton04.class){
                if (singleton == null){
                    singleton = new Singleton04();
                }
            }
        }
        return singleton;
    }
}

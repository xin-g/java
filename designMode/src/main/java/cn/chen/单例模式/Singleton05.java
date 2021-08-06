package cn.chen.单例模式;

/**
 * 登记式/静态内部类
 * 是否Lazy初始化：是
 * 是否多线程：是
 *
 * 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。
 *      对静态域使用延迟初始化，应使用这种方式而不是双检锁方式；
 *      这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用；
 *
 *      这种方式利用ClassLoader机制来保证初始化instance时只有一个线程，Singleton类被装载了，instance
 *      不一定被初始化，因为SingletonHolder类没有被主动使用，只有通过显示调用getInstance方法时，才会
 *      显示装载SingletonHolder类，从而实例化instance。
 */
public class Singleton05 {
    private static class SingletonHolder{
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    private Singleton05(){}
    public static final Singleton05 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

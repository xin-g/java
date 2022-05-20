package cn.chen.单例模式;

/**
 * JDK1.5 起
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 描述：这是实现单例模式的最佳方法。简洁，自动支持序列化机制，绝对防止多次实例化。
 */
public enum Singleton06 {
    INSTANCE;
    public void whateverMethod(){}
}

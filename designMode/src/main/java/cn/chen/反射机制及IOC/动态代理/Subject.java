package cn.chen.反射机制及IOC.动态代理;

/**
 * 定义项目接口
 */
public interface Subject {
    public String say(String name,int age);
}

/**
 * 定义真实项目
 */
class RealSubject implements Subject{

    @Override
    public String say(String name, int age) {
        return name + " " + age;
    }
}
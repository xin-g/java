package cn.chen.反射机制及IOC.动态代理;

public class Demo {
    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Subject sub = (Subject)myInvocationHandler.bind(new RealSubject());
        String info = sub.say("Rollen", 20);
        System.out.println(info);
    }
}

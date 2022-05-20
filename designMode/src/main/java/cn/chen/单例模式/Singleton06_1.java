package cn.chen.单例模式;

public class Singleton06_1 {
    private Singleton06_1(){}

    public static enum SingletonEnum{
        SINGLETON_ENUM;
        private Singleton06_1 instance = null;
        private SingletonEnum(){
            System.out.println("SingletonEnum.SingletonEnum");
            instance = new Singleton06_1();
        }
        public Singleton06_1 getInstance(){
            return instance;
        }
    }

    public static void main(String[] args) {
        Singleton06_1 instance1 = SingletonEnum.SINGLETON_ENUM.getInstance();
//        Singleton06_1 instance2 = SingletonEnum.SINGLETON_ENUM.getInstance();
//        System.out.println(instance1 );
    }
}

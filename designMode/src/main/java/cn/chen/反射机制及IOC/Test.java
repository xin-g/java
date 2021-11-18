package cn.chen.反射机制及IOC;

import java.lang.reflect.*;

public class Test {
    private String name;
    private int age;

    public Test() {
    }

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void sayChina() {
        System.out.println("hello ,china");
    }

    public void sayHello(String name, int age) {
        System.out.println(name + "  " + age);
    }

    private String sex;

    public Test(int age) {
        this.age = age;
    }

    public Test(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class hello {
    public static void main(String[] args) {
        Class<?> demo = null;

        try {
            demo = Class.forName("cn.chen.反射机制及IOC.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Test test1 = null;
        Test test2 = null;
        Test test3 = null;
        Test test4 = null;

        Constructor<?>[] cons = demo.getConstructors();

//        try {
//            test1 = (Test) cons[0].newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        for (int i = 0; i < cons.length; i++) {
//            Class<?>[] p = cons[i].getParameterTypes();
//            System.out.print("构造方法： ");
//            int mo = cons[i].getModifiers();
//            System.out.print(Modifier.toString(mo) + " ");
//            System.out.print(cons[i].getName());
//            System.out.print("(");
//            for (int j = 0; j < p.length; j++) {
//                System.out.print(p[j].getName() + " arg" + j);
//                if (j < p.length - 1){
//                    System.out.print(",");
//                }
//            }
//            System.out.println("){}");
//        }

//        System.out.println("===============本类属性========================");
//        // 取得本类的全部属性
//        Field[] field = demo.getDeclaredFields();
//        for (int i = 0; i < field.length; i++) {
//            //权限修饰符
//            int mo = field[i].getModifiers();
//            String priv = Modifier.toString(mo);
//            //属性类型
//            Class<?> type = field[i].getType();
//            System.out.println(priv + " " + type.getName() +
//                    " " + field[i].getName() + ";");
//        }
//        System.out.println("===============实现的接口或者父类的属性========================");
//        // 取得实现的接口或者父类的属性
//        Field[] field1 = demo.getFields();
//        for (int i = 0; i < field1.length; i++) {
//            // 权限修饰符
//            int mo = field1[i].getModifiers();
//            String priv = Modifier.toString(mo);
//            //属性类型
//            Class<?> type = field1[i].getType();
//            System.out.println(priv + " " + type.getName() + " "
//                + field1[i].getName() + ";");
//        }


        //通过反射调用其他类中的方法
//        try {
//            //调用TEST类中的sayChinafangfa
//            Method method = demo.getMethod("sayChina");
//            Object o = demo.newInstance();
//            System.out.println("Object:" + o);
//            method.invoke(o);
//            //调用TEST类中的sayHello
//            method = demo.getMethod("sayHello",String.class,int.class);
//            method.invoke(demo.newInstance(),"Rollen",88);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //调用其他类的set和get方法
//        Object obj = null;
//        try {
//            obj = demo.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        setter(obj,"Name","Rollen",String.class);
//        getter(obj,"Name");


        //通过反射操作属性
//        Object obj = null;
//        try {
//            obj = demo.newInstance();
//            Field field = demo.getDeclaredField("name");
//            field.setAccessible(true);
//            field.set(obj,"Ben");
//            System.out.println(field.get(obj));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        //通过反射取得并修改数组的信息
//        int[] temp = {1,2,3,4,5};
//        Class<?> de = temp.getClass().getComponentType();
//        System.out.println("数组类型：" + de.getName());
//        System.out.println("数组长度：" + Array.getLength(temp));
//        System.out.println("数组的第一个元素：" + Array.get(temp,0));
//        Array.set(temp,0,100);
//        System.out.println("修改之后数组第一个元素为：" + Array.get(temp,0));


        //通过反射修改数组大小
//        int[] temp = {1,2,3,4,5,6,7,8,9};
//        int[] newTemp = (int[]) arrayInc(temp, 15);
//        print(newTemp);
//        System.out.println("========================");
//        String[] atr = {"a","b","c"};
//        String[] str1 = (String[]) arrayInc(atr,8);
//        print(str1);


        //动态加载
        //获得类加载器
        test_t t = new test_t();
        System.out.println("类加载器 " + t.getClass().getClassLoader().getClass().getName());
    }

    public static void getter(Object obj, String att){
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setter(Object obj, String att, Object value,Class<?> type){
        try {
            Method method = obj.getClass().getMethod("set" + att,type);
            method.invoke(obj,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改数组大小
     */
    public static Object arrayInc(Object obj,int len){
        Class<?> arr = obj.getClass().getComponentType();
        System.out.println("ComponentType:" + arr);
        Object newArr = Array.newInstance(arr, len);
        int co = Array.getLength(obj);
        System.arraycopy(obj,0,newArr,0,co);
        return newArr;
    }

    /**
     * 打印
     */
    public static void print(Object obj){
        Class<?> c = obj.getClass();
        if (!c.isArray()){
            return;
        }
        System.out.println("数组长度为：" + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj,i) + " ");
        }
    }
}

class test_t{}
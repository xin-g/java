package cn.chen.原型模式;

public class CloneModel implements Cloneable{

    private String name;
    private int age;

    public CloneModel(){
        System.out.println("will new a instance");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone  >>>>>>>>>");
        return super.clone();
    }

    @Override
    public String toString() {
        return "CloneModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneModel cloneModel = new CloneModel();
        System.out.println("jkljljljl");
        System.out.println(cloneModel.clone());
    }
}

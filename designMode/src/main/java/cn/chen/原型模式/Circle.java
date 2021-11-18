package cn.chen.原型模式;

/**
 * 圆
 */
public class Circle extends Shape{

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

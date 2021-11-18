package cn.chen.原型模式;

/**
 * 正方形
 */
public class Square extends Shape{

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

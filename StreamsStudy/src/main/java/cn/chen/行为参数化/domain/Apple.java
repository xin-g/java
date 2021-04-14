package cn.chen.行为参数化.domain;

import cn.chen.行为参数化.service.Color;

public class Apple {
    private String color;
    private Integer weight;

    public Apple(String color, int weiht) {
        this.color = color;
        this.weight = weiht;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

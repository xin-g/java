package cn.chen.建造者模式.entity;

import cn.chen.建造者模式.service.Impl.itemImpl.ColdDrink;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}

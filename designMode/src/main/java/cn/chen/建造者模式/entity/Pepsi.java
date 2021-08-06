package cn.chen.建造者模式.entity;

import cn.chen.建造者模式.service.Impl.itemImpl.ColdDrink;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}

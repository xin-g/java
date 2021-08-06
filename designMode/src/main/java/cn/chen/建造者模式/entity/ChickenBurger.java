package cn.chen.建造者模式.entity;

import cn.chen.建造者模式.service.Impl.itemImpl.Burger;

public class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}

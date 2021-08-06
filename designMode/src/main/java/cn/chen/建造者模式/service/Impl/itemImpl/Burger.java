package cn.chen.建造者模式.service.Impl.itemImpl;

import cn.chen.建造者模式.service.Impl.packingImpl.Wrapper;
import cn.chen.建造者模式.service.Item;
import cn.chen.建造者模式.service.Packing;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

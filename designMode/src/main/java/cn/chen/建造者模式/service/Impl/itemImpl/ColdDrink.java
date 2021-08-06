package cn.chen.建造者模式.service.Impl.itemImpl;

import cn.chen.建造者模式.service.Impl.packingImpl.Bottle;
import cn.chen.建造者模式.service.Item;
import cn.chen.建造者模式.service.Packing;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

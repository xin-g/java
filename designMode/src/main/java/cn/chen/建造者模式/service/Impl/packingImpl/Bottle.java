package cn.chen.建造者模式.service.Impl.packingImpl;

import cn.chen.建造者模式.service.Packing;

public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}

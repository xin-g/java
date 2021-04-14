package cn.chen.行为参数化.service;

import cn.chen.行为参数化.domain.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }

}

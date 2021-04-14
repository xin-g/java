package cn.chen.行为参数化;

import cn.chen.行为参数化.domain.Apple;
import cn.chen.行为参数化.service.AppleRedAndHeavyPredicate;
import cn.chen.行为参数化.service.Color;

import java.util.ArrayList;
import java.util.List;

public class Realize {

    public static List<Apple> filterApples(List<Apple> inventory, AppleRedAndHeavyPredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(Color.RED.toString(),151));
        apples.add(new Apple(Color.RED.toString(),121));
        apples.add(new Apple(Color.GREEN.toString(),115));
        apples.add(new Apple(Color.GREEN.toString(),156));
        List<Apple> result = filterApples(apples, new AppleRedAndHeavyPredicate());
    }
}

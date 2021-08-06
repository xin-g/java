package cn.chen.建造者模式;

import cn.chen.建造者模式.entity.ChickenBurger;
import cn.chen.建造者模式.entity.Coke;
import cn.chen.建造者模式.entity.Pepsi;
import cn.chen.建造者模式.entity.VegBurger;

public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

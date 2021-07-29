package cn.chen.引入流;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT,FISH,OTHER}

    public enum CaloricLevel{DIET,NORMAL,FAT}

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Type.MEAT),
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

//        Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
//        Optional<Dish> collect = menu.stream().collect(Collectors.maxBy(dishComparator));

        //求热量平均数
//        Double collect = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));

        //总和、平均值、最大值和最小值
//        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));

        //连接字符串
//        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining("、"));

//        Integer collect = menu.stream().collect(Collectors.reducing(
//                0, Dish::getCalories, (i, j) -> i + j
//        ));

        //最大热量
//        Optional<Dish> collect = menu.stream().collect(Collectors.reducing(
//                (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
//        ));

        //将数组转换为List
//        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
//        List<Integer> reduce = stream.reduce(
//                new ArrayList<Integer>(),
//                (List<Integer> l, Integer e) -> {
//                    l.add(e);
//                    return l;
//                },
//                (List<Integer> l1, List<Integer> l2) -> {
//                    l1.addAll(l2);
//                    return l1;
//                }
//        );

        //按照热量400以下，400到700之间，多于700分组
//        Map<CaloricLevel, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(dish -> {
//            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
//            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
//            else return CaloricLevel.FAT;
//        }));

        // Collectors.filtering 做出过滤
//        Map<Type, List<Dish>> collect1 = menu.stream().collect(
//                Collectors.groupingBy(Dish::getType,
//                        Collectors.filtering(dish -> dish.getCalories() > 500,
//                                Collectors.toList()))
//        );

        // Collectors.mapping 映射
//        Map<Type, List<String>> collect = menu.stream().collect(
//                Collectors.groupingBy(Dish::getType,
//                        Collectors.mapping(Dish::getName, Collectors.toList()))
//        );


        // 菜的标签
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", Arrays.asList("greasy", "salty"));
        dishTags.put("beef", Arrays.asList("salty", "roasted"));
        dishTags.put("chicken", Arrays.asList("fried", "crisp"));
        dishTags.put("french fries", Arrays.asList("greasy", "fried"));
        dishTags.put("rice", Arrays.asList("light", "natural"));
        dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
        dishTags.put("pizza", Arrays.asList("tasty", "salty"));
        dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
        dishTags.put("salmon", Arrays.asList("delicious", "fresh"));

        // 为每类型的菜，做标签的映射
//        Map<Type, Set<String>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType,
//                Collectors.flatMapping(dish -> dishTags.get(dish.getName()).stream(),
//                        Collectors.toSet())));

        //多级分组
        Map<Type, Map<CaloricLevel, List<Dish>>> collect = menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }))
        );

//        System.out.println(collect1);
        System.out.println(collect);

    }
}

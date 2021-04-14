package cn.chen.行为参数化.service;

import cn.chen.行为参数化.domain.Apple;

public interface ApplePredicate {
    boolean test(Apple apple);
}

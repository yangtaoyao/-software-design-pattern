package com.yty.pattern.strategy;

//具体策略类B
public class ConcreteStrategyB implements Strategy {
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}
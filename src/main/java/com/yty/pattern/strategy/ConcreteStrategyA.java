package com.yty.pattern.strategy;

//具体策略类A
public class ConcreteStrategyA implements Strategy {
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}
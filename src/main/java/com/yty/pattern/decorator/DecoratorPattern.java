package com.yty.pattern.decorator;

/**
 * 装饰模式中的角色有：
 *
 * 抽象构件角色（Component）：给出一个抽象接口，以规范准备接受附加责任的对象。
 * 具体构件角色（ConcreteComponent）：定义一个将要接收附加责任的类。
 * 装饰角色（Decorator）：持有一个构件（Component）对象的实例，并定义一个与抽象构件接口一致的接口。
 * 具体装饰角色（ConcreteDecorator）：负责给构件对象“贴上”附加的责任。
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Component p = new ConcreteComponent();
        p.operation();
        System.out.println("---------------------------------");
        Component d = new ConcreteDecorator(p);
        d.operation();
    }
}

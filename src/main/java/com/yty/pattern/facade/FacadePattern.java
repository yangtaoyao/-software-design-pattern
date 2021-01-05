package com.yty.pattern.facade;

/**
 * 1.外观（Facade）角色：为多个子系统对外提供一个共同的接口。
 * 2.子系统（Sub System）角色：实现系统的部分功能，客户可以通过外观角色访问它。
 * 3.客户（Client）角色：通过一个外观角色访问各个子系统的功能。
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade f = new Facade();
        f.method();
    }
}
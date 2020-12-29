package com.yty.pattern.adapter;

/**
 * 适配者类，原业务类
 */
public class Adaptee {
    public void adapteeRequest() {
        System.out.println("被适配者的方法");
    }
}

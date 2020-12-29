package com.yty.pattern.adapter;

/**
 * 类适配，对象适配器则是通过关联来完成适配
 */
public class ObjectAdapter implements Target{
    private Adaptee adaptee=new Adaptee();

    @Override
    public void request() {
        this.adaptee.adapteeRequest();
    }
}

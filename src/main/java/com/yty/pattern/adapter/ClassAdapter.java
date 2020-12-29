package com.yty.pattern.adapter;

/**
 * 类适配，类适配器通过继承来完成适配
 */
public class ClassAdapter extends Adaptee implements Target{

    @Override
    public void request() {
        super.adapteeRequest();
    }
}

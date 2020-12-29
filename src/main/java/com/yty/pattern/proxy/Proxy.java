package com.yty.pattern.proxy;

public class Proxy implements Subject
{
    private Subject subject = new RealSubject();

    @Override
    public void operate()
    {
        System.out.print("I'm Proxy, I'm invoking...");
        this.subject.operate();
    }

    @Override
    public void doNotThing() {
        System.out.print("I'm Proxy, I'm invoking...");
        this.subject.doNotThing();
    }
}
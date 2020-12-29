package com.yty.pattern.proxy;

public class RealSubject implements Subject
{
    @Override
    public void operate()
    {
        System.out.println("--RealSubject operate ");
    }

    @Override
    public void doNotThing() {
        System.out.println("--RealSubject doNotThing ");
    }
}
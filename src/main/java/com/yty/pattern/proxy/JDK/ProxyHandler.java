package com.yty.pattern.proxy.JDK;

import com.yty.pattern.proxy.RealSubject;
import com.yty.pattern.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Jdk的动态代理是基于接口的。现在想要为RealSubject这个类创建一个动态代理对象，Jdk主要会做一下工作：
 *
 * 1 获取RealSubject上的所有接口列表
 * 2 确定要生成的代理类的类名，默认为：com.sun.proxy.$ProxyXXXX；
 * 3 根据需要实现的接口信息，在代码中动态创建该Proxy类的字节码；
 * 4 将对应的字节码转换为对于的class对象；
 * 5 创建InvocationHandler实例handler,用来处理Proxy所有方法的调用；
 * 6 Proxy的class对象以创建的handler对象为参数，实例化一个proxy对象；
 *
 */
public class ProxyHandler implements InvocationHandler {
    private Object obj=null;

    /**
     * Object Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler)
     *
     * loader，表示类加载器，对于不同来源（系统库或网络等）的类需要不同的类加载器来加载，
     *         这是Java安全模型的一部分。可以使用null来使用默认的加载器；
     * interfaces，表示接口或对象的数组，它就是前述代理对象和真实对象都必须共有的父类或者接口；
     * handler，表示调用处理器，它必须是实现了InvocationHandler接口的对象，其作用是定义代理对象中需要执行的具体操作。
     */
    public Object newProxyInstance(Object realObj){
        this.obj = realObj;
        Class<?> classType = this.obj.getClass();
        return Proxy.newProxyInstance(classType.getClassLoader(), classType.getInterfaces(), this);
    }

    /**
     * Object invoke(Object proxy, Method method, Object[] args) throws Throwable
     *
     * proxy，表示执行这个方法的代理对象；
     * method，表示真实对象实际需要执行的方法（关于Method类参见Java的反射机制）；
     * args，表示真实对象实际执行方法时所需的参数。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("I'm JDKProxy, I'm invoking...");

        method.invoke(obj, args);

        System.out.println("invoke end!");
        return null;
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject subject = (Subject) new ProxyHandler().newProxyInstance(realSubject);
        subject.operate();
        subject.doNotThing();
        System.out.println("========================");

        Subject subject2 = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.print("I'm JDKProxy, I'm invoking...");
                        method.invoke(realSubject, args);
                        System.out.println("invoke end!");
                        return null;
                    }
                });
        subject2.operate();
        subject2.doNotThing();
    }
}

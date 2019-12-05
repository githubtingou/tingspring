package com.ting.tingspring.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LISHUANG
 * @date 2019/12/5
 */
public class ProxyHandelLeran implements InvocationHandler {
    private Object object;

    public ProxyHandelLeran(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("InvocationHandler代理测试开始");
        Object invoke = method.invoke(object, args);
        System.out.println("InvocationHandler代理测试结束");
        return invoke;

    }
}

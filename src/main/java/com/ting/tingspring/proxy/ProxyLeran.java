package com.ting.tingspring.proxy;

import java.lang.reflect.Proxy;

/**
 * @author LISHUANG
 * @date 2019/12/5
 */
public class ProxyLeran {

    public static void main(String[] args) {
        ProxyTest proxyTest = new ProxyTest();
        ProxyHandelLeran proxyHandelLeran = new ProxyHandelLeran(proxyTest);
        ProxyImpl test = (ProxyImpl) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), ProxyTest.class.getInterfaces(), proxyHandelLeran);
        test.test();

    }
}

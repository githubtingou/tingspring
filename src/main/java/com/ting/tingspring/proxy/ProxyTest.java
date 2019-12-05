package com.ting.tingspring.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LISHUANG
 * @date 2019/12/5
 */
public class ProxyTest implements ProxyImpl {
    @Override
    public void test() {
        System.out.println("代理成功");
    }
}

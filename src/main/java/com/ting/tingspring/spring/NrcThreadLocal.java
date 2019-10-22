package com.ting.tingspring.spring;

/**
 * 〈文件描述〉<br>
 * 〈日志线程配置〉
 *
 * @author Administrator
 * @create 2018/6/1
 * @since 1.0.0
 */
public class NrcThreadLocal {
    public static ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    public static ThreadLocal<String> requestNo = new ThreadLocal<String>();

    public static void clearAll(){
        requestNo.remove();
        startTime.remove();
    }
}
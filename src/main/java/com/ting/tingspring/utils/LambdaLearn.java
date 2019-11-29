package com.ting.tingspring.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * lambda表达式
 *
 * @author LISHUANG
 * @date 2019/11/7
 */
public class LambdaLearn {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(4, 5, 6, 1, 2, 3, 7, 8, 8, 9, 10);

        //过滤出偶数列表 [4,6,8,8,10]
        List<Integer> evens = integers.stream().filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        //排序并且提取出前5个元素 [1,2,3,4,5]
        List<Integer> sortIntegers = integers.stream().sorted().limit(5).collect(Collectors.toList());

        //转成平方列表
        List<Integer> squareList = integers.stream().map(i -> i * i).collect(Collectors.toList());

        //求和
        int sum = integers.stream().mapToInt(Integer::intValue).sum();

        //转成其它数据结构比如set
        Set<Integer> integersSet = integers.stream().collect(Collectors.toSet());

        //根据奇偶性分组
        Map<Boolean, List<Integer>> listMap = integers.stream().collect(Collectors.groupingBy(i -> i % 2 == 0));

        //复合操作
        List<Integer> list = integers.stream().filter(i -> i % 2 == 0).map(i -> i * i).distinct().collect(Collectors.toList());
    }

}

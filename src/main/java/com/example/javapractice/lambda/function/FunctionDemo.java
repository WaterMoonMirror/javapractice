package com.example.javapractice.lambda.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/27 15:37
 * @description: java.util.function.Function<T, R>接口定义了一个叫作apply的抽象方法，它接受泛型T的对象，并返回一个泛型R的对象。
 * 如果你需要定义一个Lambda，将输入对象的信息映射到输出，就可以使用这个接口（比如提取苹果的重量，或把字符串映射为它的长度）。
 */
public class FunctionDemo {
    public static  <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        // [7, 2, 6]
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
                );
        l.forEach(System.out::println);
    }
}

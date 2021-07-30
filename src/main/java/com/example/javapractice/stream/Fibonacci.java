package com.example.javapractice.stream;

import org.mockito.internal.util.collections.Sets;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/29 15:38
 * @description: 斐波那契元组序列
 */
public class Fibonacci {
    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);
    }
}

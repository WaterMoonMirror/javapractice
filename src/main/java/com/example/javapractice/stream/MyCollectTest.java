package com.example.javapractice.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/30 11:17
 * @description: 自定义收集器
 */
public class MyCollectTest {
    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
    @Test
    public void test1(){
        IntStream.rangeClosed(1,10).boxed().collect(partitioningBy(d->isPrime(d))).get(true).forEach(System.out::println);
    }
}

package com.example.javapractice.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/29 10:02
 * @description: 归约
 */
public class ReductionTest {
    List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
    List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));

    /**
     * 获取最大值
     */
    @Test
    public void max(){
        numbers.stream().reduce(Integer::max).ifPresent(System.out::println);
    }

    /**
     *  计算有多少道菜
     */
    @Test
    public void numMenu(){
        specialMenu.stream().map(d->1).reduce(Integer::sum).ifPresent(System.out::println);
    }

}

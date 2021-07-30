package com.example.javapractice.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/28 16:45
 * @description:
 */
class StreamSliceDemoTest {
    List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));
    // 使用谓词对流进行切片
    @Test
    public void takeWhile(){
        specialMenu.stream().takeWhile(dish -> dish.getCalories()<320).collect(Collectors.toList()).forEach(System.out::println);
    }
    @Test
    public void dropWhile(){
        specialMenu.stream().dropWhile(dish -> dish.getCalories()<320).collect(Collectors.toList()).forEach(System.out::println);
    }

}

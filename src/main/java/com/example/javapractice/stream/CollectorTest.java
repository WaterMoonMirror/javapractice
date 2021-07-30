package com.example.javapractice.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/29 16:43
 * @description:
 */
public class CollectorTest {
    Map<String, List<String>> dishTags = new HashMap<>();
    @BeforeEach
    void setUp() {
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));
    }
    List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));

    /**
     *  如果你需要提取出每组菜肴对应的标签，使用flatMapping Collector可以轻松实现：
     */
    @Test
    public void test1(){
        int candidateRoot = (int) Math.sqrt((double) 8);
        System.out.println(candidateRoot);
    }

}

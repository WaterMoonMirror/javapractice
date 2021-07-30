package com.example.javapractice.lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/27 15:35
 * @description: java.util.function.Consumer<T>接口定义了一个名叫accept的抽象方法，它接受泛型T的对象，没有返回（void）。
 * 你如果需要访问类型T的对象，并对其执行某些操作，就可以使用这个接口。比如，你可以用它来创建一个forEach方法，接受一个Integers的列表，并对其中每个元素执行操作。
 */
public class ConsumerDemo {
    public static  <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }

    public static void main(String[] args) {
        forEach(
                Arrays.asList(1,2,3,4,5),
                (Integer i) -> System.out.println(i)
       );
    }
}

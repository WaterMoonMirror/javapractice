package com.example.javapractice.lambda.function;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/27 15:16
 * @description: java.util.function.Predicate<T>接口定义了一个名叫test的抽象方法，它接受泛型T对象，并返回一个boolean。
 * 这恰恰和你先前创建的一样，现在就可以直接使用了。在你需要表示一个涉及类型T的布尔表达式时，就可以使用这个接口。
 */
public class PredicateDome {
    public static  <T>List<T> filter(List<T> list, Predicate<T> p){
        List<T> result=new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PredicateDome.filter(Arrays.asList(1,2,3,4,5),e->e>3).forEach(System.out::println);
    }
}

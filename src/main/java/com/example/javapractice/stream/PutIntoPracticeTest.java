package com.example.javapractice.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/29 10:26
 * @description: 执行交易的交易员
 */
public class PutIntoPracticeTest {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );
    /**
     * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
     */
    @Test
    public void allsort(){
        transactions.stream()
                //找出2011年发生的所有交易
                .filter(t->t.getYear()==2011)
                //并按交易额排序（从低到高）。
                .sorted(comparing(Transaction::getValue))
                .collect(toList()).forEach(System.out::println);
    }
    /**
     * (2) 交易员都在哪些不同的城市工作过？
     */
    @Test
    public void differentCities(){
        transactions.stream()
                .map(t->t.getTrader().getCity())
                .distinct()
                .collect(toList()).forEach(System.out::println);
        Set<String> cities =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .collect(toSet());
    }
    /**
     * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
     *
     *
     */
    @Test
    public  void cambridgeSort(){
//        transactions.stream()
//                .filter(t->t.getTrader().getCity().equals("Cambridge"))
//                .sorted(comparing(d->d.getTrader().getName())).forEach(System.out::println);
        List<Trader> traders =
                transactions.stream()
                        .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
    }

    /**
     * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
     */
    @Test
    public void nameSort(){
//        transactions.stream()
//                .map(d->d.getTrader().getName())
//                .distinct()
//                .sorted().forEach(System.out::println);
        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
         traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());
    }

    /**
     * (5) 有没有交易员是在米兰工作的？
     */
    @Test
    public void isMl(){
        if (transactions.stream()
                .anyMatch(d->d.getTrader().getCity().equals("Milan"))) {
            System.out.println("have is milan");
        }
    }
    /**
     * (6) 打印生活在剑桥的交易员的所有交易额。
     */
    @Test
    public void jq(){
        transactions.stream()
                .filter(d->d.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    /**
     * (7) 所有交易中，最高的交易额是多少？
     */
    @Test
    public void test7(){
        transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare).ifPresent(System.out::println);
        transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
    }

    /**
     * (8) 找到交易额最小的交易。
     */
    @Test
    public void test8(){
        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .reduce((t1, t2) ->
                                t1.getValue() < t2.getValue() ? t1 : t2);
        transactions.stream()
                .min(comparing(Transaction::getValue)).ifPresent(System.out::println);
        transactions.stream()
                .sorted(comparing(Transaction::getValue)).findFirst().ifPresent(System.out::println);
    }

}

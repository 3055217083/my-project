package com.song.springboot.stream测试;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.25 15:45
 */
public class Main {

    public static void main(String[] args) {
        Instant start = Instant.now();
        learnStream();
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");
    }

    private static void learnStream() {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);
        Optional<Integer> sum = lists.parallelStream().reduce((a, b) -> a + b);//这里把stream()换成了parallelStream（）
        if (sum.isPresent()) System.out.println("list的总和为:" + sum.get());//21
        //<====> lists.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);//21
        System.out.println("list的总和为:" + sum2);
        Optional<Integer> product = lists.stream().reduce((a, b) -> a * b);
        if (product.isPresent()) System.out.println("list的积为:" + product.get());//720
        Integer product2 = lists.parallelStream().reduce(1, (a, b) -> a * b);//这里把stream()换成了parallelStream（）
        System.out.println("list的积为:" + product2);//720
    }
}
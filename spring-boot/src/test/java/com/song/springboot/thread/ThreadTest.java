package com.song.springboot.thread;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.5 13:52
 */
@SpringBootTest
public class ThreadTest {
    protected static final Logger logger = LoggerFactory.getLogger(ThreadTest.class);
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    @Test
    void test1() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());// 输出null
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }

    @Test
    void test2() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync");
            return 1 + 2;
        }, new ThreadPoolExecutor(1, 2, 3000,
                TimeUnit.MILLISECONDS, new SynchronousQueue<>()) {
        }).handleAsync((response, e) -> {
            System.out.println("handleAsync" + response);
            return 0;
        });
        System.out.println(future);
    }
}

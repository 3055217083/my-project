package com.song.springboot.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

/**
 * @author : zhixian.song
 * @description : new ThreadPoolExecutor
 * 线程池必须手动通过 ThreadPoolExecutor 的构造函数来声明
 * ，避免使用Executors  类的 newFixedThreadPool 和 newCachedThreadPool
 * ，因为可能会有 OOM 的风险。
 * @time : 2021.8.5 13:52
 */
@SpringBootTest
public class ThreadLocalTest {
    static class Person {
        String name = "zhangsan";
    }

    static ThreadLocal<Person> tl = new ThreadLocal<>();

    /**
     * *****************************
     * 无任何风险，代码想怎样写就怎样写
     * *****************************
     * @params :
     * @returns :
     */
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
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

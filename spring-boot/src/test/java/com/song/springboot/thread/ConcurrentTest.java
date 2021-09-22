package com.song.springboot.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.Instant;
import java.util.concurrent.*;

/**
 * @author : zhixian.song
 * @description : org.springframework.scheduling.concurrent;
 * @time : 2021.9.3 10:10
 */
@Slf4j
@SpringBootTest
public class ConcurrentTest {
    @Autowired
    private ThreadPoolTaskExecutor applicationTaskExecutor;
    @Test
    void test1() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(TimeUnit.DAYS.toHours(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Future<Integer> a;
        a = applicationTaskExecutor.submit(() -> 1);
        try {
            System.out.println(a.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "date：" + Instant.now());
            });
        }
        //终止线程池
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");


    }

}

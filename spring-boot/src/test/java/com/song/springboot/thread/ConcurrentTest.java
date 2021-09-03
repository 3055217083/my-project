package com.song.springboot.thread;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.9.3 10:10
 */
@SpringBootTest
public class ConcurrentTest {
    @Autowired
    private ThreadPoolTaskExecutor applicationTaskExecutor;
    @Test
    void test1() {
        Future<Integer> a;
        a = applicationTaskExecutor.submit(() -> 1);
        try {
            System.out.println(a.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

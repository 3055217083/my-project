package com.song.springboot.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : zhixian.song
 * @description : Executors.newFixedThreadPool 方式创建线程池
 * @time : 2021/7/5 9:52
 */
public class ThreadsTest {
    public static void main(String[] args) {
        ThreadPoolDemo tp = new ThreadPoolDemo();
        //1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //2.为线程池中的线程分配任务
        pool.submit(tp);
        pool.submit(tp);
        //3.关闭线程池
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (i < 100) {
            System.out.println(Thread.currentThread().getName() + ":" + (i++));
        }
    }
}

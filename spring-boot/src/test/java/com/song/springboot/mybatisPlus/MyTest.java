package com.song.springboot.mybatisPlus;

import com.song.springboot.entity.learn.User;
import com.song.springboot.outcall.test;
import com.song.springboot.service.learn.MyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/7 9:21
 */
@SpringBootTest
public class MyTest {
    @Autowired
    MyServiceImpl myService;
    @Autowired
    test test;

    @Test
    public void test() {
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));

        System.out.println(df.format(System.currentTimeMillis()));

        Calendar c = Calendar.getInstance();

        long begin = System.currentTimeMillis(); //执行前计算据1970年毫秒数
        System.out.println(13);
        myService.save(new User("SB"));
        long end = System.currentTimeMillis(); //执行完后计算据1970年毫秒数
        System.out.println("耗费时长" + (end - begin) + "毫秒");
    }

    @Test
    public void test2() {
        test.goTest();
    }
}

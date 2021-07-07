package com.song.springboot.mybatisPlus;

import com.song.springboot.entity.learn.User;
import com.song.springboot.service.MyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/7 9:21
 */
@SpringBootTest
public class MyTest {
    @Autowired
    MyServiceImpl myService;

    @Test
    public void test() {
        System.out.println(13);
        myService.save(new User("SB"));
    }
}

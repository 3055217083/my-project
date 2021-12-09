package com.song.springboot.hashTest;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.12.6 上午 09:49
 */
@SpringBootTest
@DisplayName("╯°□°）╯")
public class HashTest {
    Gson gson = new Gson();

    @Test
    void test1() {
        Calendar calendar=Calendar.getInstance();
        HashSet<TestVO> hashSet = new HashSet<>();
        calendar.add(Calendar.MONTH,1);
        System.out.println(hashSet.add(new TestVO("1", "2", calendar.getTime(), new Date(),"1")));
        calendar.add(Calendar.MONTH,2);
        System.out.println(hashSet.add(new TestVO("1", "2", calendar.getTime(), calendar.getTime(),"2")));
        System.out.println(hashSet);
    }
}

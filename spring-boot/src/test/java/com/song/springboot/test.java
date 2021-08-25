package com.song.springboot;

import com.song.springboot.viewObject.MyVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/29 10:25
 */
@SpringBootTest
public class test {
    @Test
    void test1() {
        String name = "123";
        List<String> xiaoMing = new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
            add("c");
        }};
        List<String> stringList = Arrays.asList("a", "b", "c");
        MyVO myVO = new MyVO(name, xiaoMing);
        // myVO.getXiaoMing().removeIf(xiaoMing2 -> xiaoMing2.equals("2"));
        myVO.setXiaoMing(myVO.getXiaoMing().stream().filter(ming -> ming.equals("a")).collect(Collectors.toList()));
        System.out.println(myVO);
    }

    @Test
    void test3() {
        int 你在干什么呢 = 123;
        int 我没干嘛呀 = 12;
        System.out.println(你在干什么呢 / 我没干嘛呀);
    }
}

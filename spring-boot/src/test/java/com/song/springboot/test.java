package com.song.springboot;

import com.song.springboot.viewObject.MyVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/29 10:25
 */
@SpringBootTest
@DisplayName("╯°□°）╯")
public class test {
    @Test
    void test1() {
        assertTrue(true, "错误");
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

    @Test
    void test4() throws UnsupportedEncodingException {
        String s = "这是一段中文字符串";
        byte[] b = s.getBytes(StandardCharsets.UTF_8);
        String n = new String(b, StandardCharsets.UTF_8);
        System.out.println(b + n);


        String s2 = "我是 cm";
        byte[] bytes = s2.getBytes();
        String s1 = new String(bytes, "GBK");
        String s3 = new String(bytes);
        System.out.println(s1 + s3 + bytes);
    }
}

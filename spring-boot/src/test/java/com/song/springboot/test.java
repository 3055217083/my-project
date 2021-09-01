package com.song.springboot;

import com.google.gson.*;
import com.song.springboot.utils.HttpClientUtil;
import com.song.springboot.viewObject.MyVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;
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
    Gson gson = new Gson();
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
        float 你到底在干什么 = 123;
        BigDecimal 银行卡余额 = BigDecimal.valueOf(0.03 - 0.02);
        BigDecimal 没钱了 = new BigDecimal("0.03");
        BigDecimal 没钱交房租了 = new BigDecimal("0.02");
        System.out.println(你在干什么呢 / 我没干嘛呀 + "        " + 银行卡余额);
        System.out.println(没钱了.subtract(没钱交房租了));
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

    @Test
    void test5() throws Exception {
        test6();
    }

    @Async("threadPoolTaskExecutor")
    void test6() {
        System.out.println("123456789************");
    }

    @Test
    void test7() {
        Map<String, String> params = new HashMap<>();
        JsonObject paramJson = new JsonObject();
        paramJson.addProperty("usr_id", "20190229244");
        params.put("data", paramJson.toString());
        String url = "http://fnauth.beta1.fn/openapi/rt/new/queryMappingStoreAndArea.do";
        String callApiResult = HttpClientUtil.sendPost(url, params);
        JsonElement jsonBody = new JsonParser().parse(callApiResult);
        JsonArray jsonData = jsonBody.getAsJsonObject().getAsJsonObject("data").getAsJsonArray("area");
    }

    @Test
    void test8() {
        Gson gson = new Gson();
        gson.toJson(1);            // ==> 1
        gson.toJson("abcd");       // ==> "abcd"
        gson.toJson(new Long(10)); // ==> 10
        int[] values = {1};
        gson.toJson(values);       // ==> [1]

        // Deserialization
        int one = gson.fromJson("1", int.class);
        Integer one2 = gson.fromJson("1", Integer.class);
        Long one3 = gson.fromJson("1", Long.class);
        Boolean false2 = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"abc\"", String.class);
        String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
    }
}

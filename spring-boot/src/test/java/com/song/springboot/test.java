package com.song.springboot;

import com.google.common.base.Objects;
import com.google.gson.*;
import com.song.springboot.service.MongoDbService;
import com.song.springboot.service.csv.Template;
import com.song.springboot.service.csv.csv文件转化java对象的类_懂了吗;
import com.song.springboot.utils.HttpClientUtil;
import com.song.springboot.viewObject.MyVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
    @Autowired
    private ApplicationContext applicationContext;
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
        gson.toJson(10L); // ==> 10
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

    @Test
    void test9() {
        csv文件转化java对象的类_懂了吗
                .csvToBeanList("C:\\Users\\zhixian.song\\Desktop\\template.csv", ",", true, Template.class, "GBK");
    }

    @Test
    void test10() {
        MultipartFile file = null;
        ArrayList<Template> csvFileList = new ArrayList<>();
        InputStreamReader in = null;
        String s = null;
        try {
            in = new InputStreamReader(file.getInputStream(), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(in);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                Template csvFile = new Template();
                csvFile.setScheduleNo(splitResult(split[0]));
                csvFile.setStyleNo(Integer.valueOf(split[1]));
                csvFile.setPrice(BigDecimal.valueOf(Double.parseDouble(splitResult(split[2]))));
                csvFile.setStore(splitResult(split[3]));
                csvFile.setRemark(splitResult(split[4]));
                csvFileList.add(csvFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String splitResult(String once) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < once.length(); i++) {
            if (once.charAt(i) != '"') {
                result.append(once.charAt(i));
            }
        }
        return result.toString();
    }

    @Test
    void test11() {
        //定义
        LinkedList<Integer> deque = new LinkedList<>();

        deque.addFirst(1);    //在队列头部添加
        deque.pollFirst();    //删除头部第一个元素（等价于poll()）
        deque.peekFirst();    //获取头部第一个元素（等价于peek()）

        deque.addLast(1);    //在队列尾部添加（等价于add()）
        deque.pollLast();    //删除尾部第一个元素
        deque.peekLast();    //获取尾部第一个元素
    }

    @Autowired
    MongoDbService mongoDbService;

    @Test
    void test12() {
        System.out.print(mongoDbService.showCollectionNames());
    }

    static volatile int n = 0;

    @Test
    void test13() throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/123.csv"), "GBK"));
    }
/*[6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 2, 1, 1, 1]*/
    @Test
    void test14() {
        List<Integer> theList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2));
        theList = theList.stream().sorted((a, b) -> {
            boolean e1 = com.google.common.base.Objects.equal(a, b);
            boolean e2 = Objects.equal(a, b);
            if(e1 && !e2) {
                return -1;
            }else {
                return a <= b ? 1:-1;
            }
        }).collect(Collectors.toList());
        System.out.println(theList);
    }
}

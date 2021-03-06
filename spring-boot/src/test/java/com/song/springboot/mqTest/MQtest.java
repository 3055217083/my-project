package com.song.springboot.mqTest;


import com.song.springboot.entity.learn.Order;
import com.song.springboot.mq.learn.OrderSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/7 10:04
 */
@SpringBootTest
public class MQtest {
    @Autowired
    private OrderSender orderSender;

    @Test
    void test2() throws Exception {
        Order order = new Order("1234", "szx", System.currentTimeMillis() + "#" + UUID.randomUUID().toString());
        orderSender.send(order);
    }
}

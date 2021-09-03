package com.song.springboot.mq.learn;

import com.rabbitmq.client.Channel;
import com.song.springboot.entity.learn.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/10 10:12
 */
@Component
public class OrderReceiver {
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true")
            , exchange = @Exchange(name = "order-exchange", durable = "true", type = "topic")
            , key = "order.*")
    )
    public void get(@Payload Order order, @Headers Map<String, Object> headers
            , Channel channel) throws Exception {
        System.out.println("开始消费++++++++++");
        System.out.println(order.getId());
        channel.basicAck((long) headers.get(AmqpHeaders.DELIVERY_TAG), false);
    }
}

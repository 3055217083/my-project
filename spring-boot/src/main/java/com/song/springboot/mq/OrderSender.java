package com.song.springboot.mq;

import com.song.springboot.entity.learn.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/10 10:12
 */
@Component
public class OrderSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) throws Exception {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getId());
        rabbitTemplate.convertAndSend("order-exchange"
                , "order.abcd"
                , order, correlationData);
    }
}

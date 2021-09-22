package com.song.springboot.mqTest;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 * @author szx
 * @Date
 */
public class Consumer {

    public static void main(String[] args) {
        //所有中间件技术都是基于tcp/ip协议基础上构建的新型协议 RabbitMQ遵循的是amqp
        //只要是tcp/ip协议永远都逃不掉 的是ip 和端口号port

        //1.创建链接工程 设置账号密码等连接信息
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        factory.setVirtualHost("/");//设置虚拟访问节点
        Connection connection = null;
        Channel channel = null;
        try {
            // 2.创建链接connection
            connection = factory.newConnection("生产者");
            // 3.通过连接获取通道Channel
            channel = connection.createChannel();
            // 4.通过创建交换机 队列 绑定关系 路由Key 发生消息 和接收消息
            String queueName = "queue1"; //队列名称

            //消费消息
            //接收消息失败时执行
            channel.basicConsume(queueName, true, new DeliverCallback() { //接收消息成功时执行
                public void handle(String consumerTag, Delivery message) throws IOException {
                    System.out.println("接收消息:" + new String(message.getBody(), StandardCharsets.UTF_8));
                }
            }, consumerTag -> System.out.println("接收消息失败"));
            System.in.read();//阻断 不往下执行
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (IOException | TimeoutException e) {
                    e.printStackTrace();
                }
            }
            //8.关闭连接
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


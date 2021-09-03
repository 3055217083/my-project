package com.song.springboot.mqTest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 * @author szx
 * @Date 2021/7/27 15:10
 */
public class Producer {
    public static void main(String[] args) {
        //所有中间件技术都是基于tcp/ip协议基础上构建的新型协议 RabbitMQ遵循的是amqp
        //只要是tcp/ip协议永远都逃不掉 的是ip 和端口号port

        //1.创建链接工程 设置账号密码等连接信息
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("guest"); //用户名
        factory.setPassword("guest"); //密码
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

            /**
             * @params1 队列名称
             * @params2 是否持久化
             * @params3 是否具有排他性 是否独占队列
             * @params4 是否自动删除队列 最后一个消息被消费完 是否删除队列
             * @params5 携带附加参数
             */
            channel.queueDeclare(queueName, false, false, false, null);
            // 5.准备消息
            String message = "Hello,RabbitMQ!";
            // 6.发生消息给队列
            /**
             * @params1 交换机
             * @params2 队列名 路由Key
             * @params3 消息是否持久化
             * @params5 消息主体
             */
            channel.basicPublish("", queueName, null, message.getBytes());

            System.out.println("消息发送完毕");
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

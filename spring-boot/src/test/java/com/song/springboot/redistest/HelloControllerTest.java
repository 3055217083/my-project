package com.song.springboot.redistest;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/22 17:21
 */
@SpringBootTest
class HelloControllerTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    void testSimple() {
        redisTemplate.opsForValue().set("myWeb", "www.choupangxia.com");
        Assertions.assertEquals("www.choupangxia.com", redisTemplate.opsForValue()
                .get("myWeb"), "第一个验证");
        Assertions.assertEquals("www.choupangxia.com", stringRedisTemplate.opsForValue()
                .get("myWeb"), "第二个验证");
    }

    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());
        //关闭连接
        connection.close();
    }

    /**
     * jdbcTemplate
     * @params :
     * @returns :
     */
    @Test
    public void map() {
        System.out.println(jdbcTemplate.queryForList("select * FROM user"));
    }

    @Test
    public void testHttpClient() throws Exception {
        // TODO Auto-generated method stub
        //1,创建一个httpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //2,创建uriBuilder 对于httpClient4.3访问指定页面url必须要使用http://开始
        URIBuilder uriBuilder=new URIBuilder("http://www.baidu.com");
        //4,创建httpget对象
        HttpGet httpGet=new HttpGet(uriBuilder.build());
        //5,设置请求报文头部的编码
        httpGet.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; utf-8"));
        //6,设置期望服务返回的编码
        httpGet.setHeader(new BasicHeader("Accept","text/plain;charset=utf-8"));
        //7，请求服务
        CloseableHttpResponse response=client.execute(httpGet);
        //8，获取请求返回码
        int statusCode=response.getStatusLine().getStatusCode();
        //9如果请求返回码是200，则说明请求成功
        if(statusCode==200){
            //10,获取返回实体
            HttpEntity entity=response.getEntity();
            //11,通过EntityUtils的一个工具类获取返回的内容
            String str= EntityUtils.toString(entity);
            System.out.println("请求成功的返回内容："+str);

        }else{
            System.out.println("请求失败！");
        }
        response.close();
        client.close();
    }
}

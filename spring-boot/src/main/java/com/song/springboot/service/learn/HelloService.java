package com.song.springboot.service.learn;

import com.song.springboot.annotation.MyLog;
import com.song.springboot.entity.learn.Book;
import com.song.springboot.mapper.learn.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/21 10:33
 */
@Service
public class HelloService {
    @Autowired
    HelloMapper helloMapper;

    @MyLog
    public Book selectAll(){
       return helloMapper.selectAll();
    }
}

package com.song.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.springboot.entity.learn.User;
import com.song.springboot.mapper.UserMapper;
import com.song.springboot.service.learn.MyService;
import org.springframework.stereotype.Service;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/7 9:16
 */
@Service
public class MyServiceImpl extends ServiceImpl<UserMapper, User> implements MyService {

}

package com.song.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.springboot.entity.learn.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/21 10:35
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

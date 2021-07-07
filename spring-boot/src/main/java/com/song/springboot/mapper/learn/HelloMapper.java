package com.song.springboot.mapper.learn;

import com.song.springboot.entity.learn.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/21 10:35
 */
@Mapper
public interface HelloMapper {
    /**
     * @description : cha xun suo you
     * @params : null
     * @return : shu
     */
    Book selectAll();
}

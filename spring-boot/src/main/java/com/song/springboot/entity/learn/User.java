package com.song.springboot.entity.learn;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/22 17:59
 */
@Data
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
    private String email;
    private String authority;

    public User(String name) {
        this.name = name;
    }
}

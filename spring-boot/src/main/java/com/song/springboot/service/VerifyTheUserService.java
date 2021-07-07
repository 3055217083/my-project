package com.song.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.song.springboot.entity.learn.User;
import com.song.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/6 14:06
 */
@Service
public class VerifyTheUserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("name", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("not found");
        }
        // 用户名 密码 权限
        return new org.springframework.security.core.userdetails.User(user.getName()
                , new BCryptPasswordEncoder().encode(user.getPassword())
                , AuthorityUtils.createAuthorityList(user.getAuthority().split(",")));
    }
}


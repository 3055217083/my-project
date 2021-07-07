package com.song.springboot.config;

import com.song.springboot.service.VerifyTheUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/6 13:54
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private VerifyTheUserService verifyTheUserService;

    /**
     * 内存认证
     * Spring Security5.x默认BCrypt加密，加密后的格式为 {加密编码}加密后的密码
     *
     * @params : auth
     * @returns :
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 明文密码
        auth.inMemoryAuthentication().withUser("user").password("123456").roles();
        // BCrypt加密
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("123456")).roles();
        auth.userDetailsService(verifyTheUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 授权
     *
     * @params :
     * @returns :
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .logout()
                .permitAll();
        /*@PreAuthorize --适合进入方法之前验证授权
          @PostAuthorize --检查授权方法之后才被执行
          @PostFilter --在方法执行之后执行，而且这里可以调用方法的返回值，然后对返回值进行过滤或处理或修改并返回
          @PreFilter --在方法执行之前执行，而且这里可以调用方法的参数，然后对参数值进行过滤或处理或修改*/
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

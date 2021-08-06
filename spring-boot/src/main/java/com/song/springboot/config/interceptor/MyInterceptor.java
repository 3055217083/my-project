package com.song.springboot.config.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/30 16:01
 */
/*
 * 1.类直接实现HandlerInterceptor 或直接实现AsyncHandlerInterceptor
 * 2.实现HandlerInterceptor接口，并实现其中的三个方法
 * 3.preHandle方法：在业务处理器处理请求之前被调用，预处理
 * ,可以进行编码、安全控制、权限校验等处理换句话说就是请求在达到controller层之前会被拦截并运行preHandle方法。
 * 4.postHandle方法：在业务处理器处理请求执行完成后，生成视图之前执行
 * 。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView ；
 * 5.registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/hello"); 注册住了
 * */
@Component
public class MyInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //todo 处理拦截逻辑
        //如果返回false则 postHandle()和 afterCompletion()不会执行
        System.out.println(123456789);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}

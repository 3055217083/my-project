package com.song.springboot.controller.used4study或者test;

import com.song.springboot.AAA_TWO2222222222.燃えろ俺の小宇宙よ.NameEnum;
import com.song.springboot.entity.learn.Book;
import com.song.springboot.service.learn.HelloService;
import com.song.springboot.utils.ProjectProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/21 9:46
 */
@Controller
public class HelloController {
    @Value("${env}")
    String env;

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    HelloService helloService;

    @ResponseBody
    @GetMapping(value = {"/in", "/f"})
    Book getHello() throws Exception {
        if (false) {
            NameEnum nameEnum = NameEnum.SONG_ZHI_XIAN;
            throw new Exception("12321");
        }
        return helloService.selectAll();
    }

    @GetMapping(value = {"/"}, produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
    @ResponseBody
    String index(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(env);

        for (Map.Entry<Object, Object> entry : ProjectProperties.getProperties().entrySet()) {
            String name = (String) entry.getKey();
            Object value = entry.getValue();
            System.out.format("%s::::::::::::::::::::::::::::::::%s",name,value);
            System.out.println();
        }

        request.getRequestURI();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        return "首页";
    }

    @Secured({"ROLE_1", "ROLE_2"})
    @RolesAllowed({"1", "2"})
    @PreAuthorize("hasRole('ROLE_1')")
    @GetMapping(value = {"/hello"})
    String goToJSP() {
        return "used4studyORtest/hello";
    }

    @GetMapping(value = {"/nihao"})
    String goToHTML() {
        return "html/used4studyORtest/hello2";
    }

    @GetMapping("/error/404")
    public String error404() {
        return "templates/error/40X";
    }

    @GetMapping("/error/500")
    public String error500() {
        return "templates/error/50X";
    }
}

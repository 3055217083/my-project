package com.song.springboot.api;

import com.song.springboot.entity.learn.Book;
import com.song.springboot.service.learn.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/21 9:46
 */
@Api(tags = "我的api")
@RestController(value = "apiController")
@RequestMapping("/api")
public class HelloController {

    @Autowired
    HelloService helloService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "书名", paramType = "query", dataType = "String", required = false)
    })
    @ApiOperation(value = "获取book", httpMethod = "POST", notes = "获取书本notes)", response = Book.class)
    @RequestMapping(value = {"/api1", "/api2"})
    public Book getHello(String name) {
        return new Book(1, "从入门到出门");
    }
}

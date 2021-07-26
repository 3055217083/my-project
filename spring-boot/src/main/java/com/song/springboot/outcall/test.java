package com.song.springboot.outcall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/26 12:03
 */
@FeignClient(name = "apiController",
        url = "localhost:8081",
        path = "/api")
public interface test {
    @PostMapping("/api1")
    String goTest();
}

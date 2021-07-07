package com.song.springboot.controller.used4study或者test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class RouterController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "templates/index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "templates/views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id) {
        return "templates/views/level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id) {
        return "templates/views/level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id) {
        return "templates/views/level3/" + id;
    }

}

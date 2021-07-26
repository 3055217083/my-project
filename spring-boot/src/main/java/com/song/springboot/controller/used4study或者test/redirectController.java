package com.song.springboot.controller.used4study或者test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/7 16:27
 */
@Controller
public class redirectController {

    @RequestMapping("/jump")
    public ModelAndView jump(HttpServletRequest httpServletRequest, Model model) {
        return new ModelAndView("html/used4studyORtest/redirection");
    }

    @RequestMapping("/jump2")
    public String jump2(HttpServletRequest httpServletRequest, Model model) {
        return "html/used4studyORtest/redirection2";
    }
}

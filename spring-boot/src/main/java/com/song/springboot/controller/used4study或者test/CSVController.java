package com.song.springboot.controller.used4study或者test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.song.springboot.service.csv.CSV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.31 9:31
 */
@Controller
@RequestMapping("/csv")
public class CSVController {
    private static final Gson gson = new GsonBuilder().create();
    @Autowired
    CSV2 csv2;
    String[] HEADERS = {"档期(请填4位档期编号）", "款号"};

    @RequestMapping(value = {"/", ""})
    String csv() {
        return "csv";
    }

    @RequestMapping(value = "/letItGo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    int letItGo(@RequestParam("file") MultipartFile file) throws Exception {
        return csv2.test10(file);
    }
}

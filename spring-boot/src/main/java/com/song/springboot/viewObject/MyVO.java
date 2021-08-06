package com.song.springboot.viewObject;

import java.util.List;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/29 10:24
 */
public class MyVO {
    String name;
    List<String> xiaoMing;

    public MyVO() {
    }

    public MyVO(String name, List<String> xiaoMing) {
        this.name = name;
        this.xiaoMing = xiaoMing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getXiaoMing() {
        return xiaoMing;
    }

    public void setXiaoMing(List<String> xiaoMing) {
        this.xiaoMing = xiaoMing;
    }
}

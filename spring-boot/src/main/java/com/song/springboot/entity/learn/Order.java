package com.song.springboot.entity.learn;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/10 9:53
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1544627609962467038L;

    @JsonFormat
    private String id;
    private String name;
    private String messageId;

    public Order(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}

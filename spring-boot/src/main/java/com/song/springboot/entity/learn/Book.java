package com.song.springboot.entity.learn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/21 10:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int book_id;
    private String name;
    private int number;

    public Book(int book_id, String name) {
        this.book_id = book_id;
        this.name = name;
    }
}

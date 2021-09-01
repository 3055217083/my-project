package com.song.springboot.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.31 10:59
 */
@Service
public class CSV {
    public int 解析这个csv文件吧(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
        Iterable<CSVRecord> records = CSVFormat.RFC4180.DEFAULT.parse(reader);
        for (CSVRecord record : records) {
            String lastName = record.get(0);
            String firstName = record.get(1);
            System.out.print(lastName + "   " + firstName);
            System.out.println(record.get(2) + "  " + record.get(3));
        }
        return 0;
    }

    public enum Headers {
        ID, CustomerNo, Name
    }
}

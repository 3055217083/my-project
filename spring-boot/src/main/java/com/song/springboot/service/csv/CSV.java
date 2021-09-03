package com.song.springboot.service.csv;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.31 10:59
 */
@Service
public class CSV {
    public int 解析这个csv文件吧(MultipartFile file) throws Exception {
      InputStream inputStream = file.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
      /*    Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
        for (CSVRecord record : records) {
            System.out.print(record.toList());
            System.out.print(record.get(0));
            System.out.print(record.get(1));
            System.out.print(record.get(2));
            System.out.print(record.get(3));
            System.out.println(record.get(4));
        }*/
        try {
            csv文件转化java对象的类_懂了吗.csvToBeanList(reader,",",true, Template.class);
        } catch (FileResolveException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.getMessage();
        }
        return 0;
    }

    public enum Headers {
        ID, CustomerNo, Name
    }
}

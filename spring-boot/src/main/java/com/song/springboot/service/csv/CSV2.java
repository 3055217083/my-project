package com.song.springboot.service.csv;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.31 10:59
 */
@Service
public class CSV2 {
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
    /**
     * TODO
     * @params :
     * @returns :
     */
    public int test10(MultipartFile file) {
        ArrayList<Template> csvFileList = new ArrayList<>();
        InputStreamReader in = null;
        String s = null;
        try {
            in = new InputStreamReader(file.getInputStream(), "GBK");
            BufferedReader bufferedReader = new BufferedReader(in);
            String line = null;bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                Template csvFile = new Template();
                csvFile.setScheduleNo(splitResult(split[0]));
                csvFile.setStyleNo(Integer.valueOf(split[1]));
                csvFile.setPrice(BigDecimal.valueOf(Double.parseDouble(splitResult(split[2]))));
                csvFile.setStore(splitResult(split[3]));
                csvFile.setRemark(splitResult(split[4]));
                csvFileList.add(csvFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * TODO
     * @params :
     * @returns :
     */
    private static String splitResult(String once) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < once.length(); i++) {
            if (once.charAt(i) != '"') {
                result.append(once.charAt(i));
            }
        }
        return result.toString();
    }
}

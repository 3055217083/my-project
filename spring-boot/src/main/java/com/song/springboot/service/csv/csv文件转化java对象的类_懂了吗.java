package com.song.springboot.service.csv;

import org.apache.commons.lang3.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.9.1 11:42
 */

public class csv文件转化java对象的类_懂了吗 {

    /**
     * TODO
     * @params : 文件路径，分割符号，ignoreFirstLine，类，字符集
     * @returns :
     */
    public static <T> List<T> csvToBeanList(String filePath, String split, boolean ignoreFirstLine
            , Class<T> clazz, String charset) {
        try (final FileInputStream fileInputStream = new FileInputStream(filePath)) {
            return csvToBeanList(new InputStreamReader(fileInputStream, charset), split,
                    ignoreFirstLine, clazz);
        } catch (IOException e) {
            throw new FileResolveException("文件读取异常", e);
        }
    }

    /**
     * TODO
     * @params :输入流，分割符号，ignoreFirstLine，类
     * @returns :
     */
    public static <T> List<T> csvToBeanList(Reader in, String splitMark, boolean ignoreFirstLine
            , Class<T> clazz) throws IOException {
        List<T> result = new ArrayList<>();
        List<String> errorInfos = new ArrayList<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        Method[] methods = clazz.getMethods();
        //临时使用
        Method tm = methods[0];
        LinkedHashMap<Field, Method> fieldMethodMap = Stream.of(declaredFields)
                .filter(f -> f.getAnnotation(FieldWithCSV.class) != null)
                .sorted(Comparator.comparingInt(f -> f.getAnnotation(FieldWithCSV.class).num()))
                .collect(Collectors.toMap(f -> f, f -> {
                    try {
                        return new PropertyDescriptor(f.getName(), clazz).getWriteMethod();
                    } catch (IntrospectionException e) {
                        e.printStackTrace();
                    }
                    return tm;
                }, (v1, v2) -> v1, LinkedHashMap::new));
        try (BufferedReader reader = new BufferedReader(in)) {
            String line;
            int lineNum = 0;
            if (ignoreFirstLine) {
                lineNum++;
                final String[] firstLines = reader.readLine().split(",", -1);
                if (firstLines.length != fieldMethodMap.size()) {
                    String errorInfo = "文件列数不匹配，当前需要列为," + fieldMethodMap.keySet().stream()
                            .map(field -> field.getAnnotation(FieldWithCSV.class).title())
                            .collect(Collectors.joining(","));
                    throw new FileResolveException(errorInfo);
                }
            }
            while (StringUtils.isNotEmpty(line = reader.readLine())) {
                lineNum += 1;
                try {
                    T t = clazz.newInstance();
                    String[] data = line.split(splitMark);
                    for (Map.Entry<Field, Method> entry : fieldMethodMap.entrySet()) {
                        Field f = entry.getKey();
                        Method m = entry.getValue();
                        FieldWithCSV annotation = f.getAnnotation(FieldWithCSV.class);
                        int num = annotation.num();
                        if (num < data.length) {
                            Class<?> type = f.getType();
                            String d = data[num].trim();
                            if (StringUtils.isEmpty(d)) {
                                if (!annotation.isOkNull()) {
                                    errorInfos.add(String.format("文件第%d行第%d列:%s", lineNum, num+1, "数据为空"));
                                    break;
                                }
                                continue;
                            }
                            if (type == Integer.class) {
                                m.invoke(t, Integer.valueOf(d));
                            } else if (type == Long.class) {
                                m.invoke(t, Long.valueOf(d));
                            } else if (type == Float.class) {
                                m.invoke(t, Float.valueOf(d));
                            } else if (type == Double.class) {
                                m.invoke(t, Double.valueOf(d));
                            } else if (type == String.class) {
                                m.invoke(t, d);
                            } else if (type == BigDecimal.class) {
                                m.invoke(t, BigDecimal.valueOf(Double.parseDouble(d)));
                            } else if (type == Date.class) {
                                m.invoke(t, new SimpleDateFormat(annotation.dateFormat()).parse(d));
                            }
                        }
                    }
                    result.add(t);
                } catch (NumberFormatException | ParseException e) {
                    e.printStackTrace();
                    errorInfos.add(String.format("文件第%d行:%s", lineNum, "数据格式错误"));
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                    errorInfos.add("系统错误");
                } catch (Exception e) {
                    e.printStackTrace();
                    errorInfos.add("未知错误");
                }
            }
        }
        if (!errorInfos.isEmpty()) {
            throw new FileResolveException(errorInfos);
        }
        return result;
    }

}

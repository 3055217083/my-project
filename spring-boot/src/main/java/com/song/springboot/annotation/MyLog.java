package com.song.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.9.2 14:28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {
    /**
     * 日志类型：  0: 异常  1: 新增  2: 更新  3: 删除
     */
    int logType() default 0;

    /**
     * 日志名称: 默认 "系统数据操作日志"
     */
    String logName() default "系统数据操作日志";

    /**
     * 功能模块名
     */
    String logModel() default "";

    /**
     * 备注
     */
    String remark() default "";
}

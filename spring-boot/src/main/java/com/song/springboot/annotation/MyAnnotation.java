package com.song.springboot.annotation;

import java.lang.annotation.*;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/30 17:47
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    String value();
}

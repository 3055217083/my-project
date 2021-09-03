package com.song.springboot.service.csv;

import java.lang.annotation.*;

/**
 * TODO
 * @params :
 * @returns :
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldWithCSV {

    int num() default 0;

    String title() default "";

    String dateFormat() default "";

    boolean isOkNull() default true;
}

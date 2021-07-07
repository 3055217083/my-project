package com.song.springboot.exception;

import com.song.springboot.dto.ResponseBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author zhixian.song
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SQLException.class)
    public ResponseBean sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return ResponseBean.error("该数据有关联数据，操作失败!");
        }
        return ResponseBean.error("数据库异常，操作失败!");
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView catchException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("templates/error/error");
        modelAndView.addObject("msg", e.getMessage());
        return modelAndView;
    }
}

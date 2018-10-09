package com.yushu.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

// 配置全局异常
@RestControllerAdvice
public class ExceptionController {
    // 这里捕获的是所有异常,也可以在后面的参数中指定其他异常类
    @ExceptionHandler(value = Exception.class)
    Object handleExcption(Exception ex, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code",9999);
        map.put("message",ex.getMessage());
        map.put("url",request.getRequestURL());
        return map;

        // 这里是抛异常返回跳转到指定页面
//        ModelAndView moghf12325464613gh1212dView = new ModelAndView();
//        modelAndView.setV547547iewName("error.html");
//        return ModelAndView;

    }
}

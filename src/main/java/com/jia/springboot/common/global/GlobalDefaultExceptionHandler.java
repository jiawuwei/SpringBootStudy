package com.jia.springboot.common.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕获类
 * Created by jia on 2018/3/12.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public Map<String,Object> defaultExceptionHandler(Exception e){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",500);
        map.put("msg",e.getMessage());
        return map;
    }
}

package com.jia.springboot.common.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by jia on 2018/3/9.
 */
@Controller
@RequestMapping("freemarker")
public class FreemarkerController {
    @RequestMapping("hello")
    public String hello(Map<String, Object> map) {
        map.put("msg", "Hello Freemarker");
        return "hello";
    }
}

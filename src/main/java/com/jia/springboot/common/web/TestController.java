package com.jia.springboot.common.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jia on 2018/3/9.
 */
@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping(value = {"1","helloworld1"})
    public String helloworld(){
        return "helloworld";
    }
    @GetMapping(value = {"2","helloworld2"})
    public String helloworld2(){
        return "helloworld1";
    }
    @GetMapping(value = {"3","helloworld3"})
    public String helloworld3(){
        return "helloworld1";
    }
}

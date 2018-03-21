package com.jia.springboot.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jia on 2018/3/9.
 */
@Controller
@RequestMapping("/")
public class WebSocketTestController {
    @GetMapping(value = {"websocket"})
    public String helloworld(){

        return "websocketTest";
    }

}

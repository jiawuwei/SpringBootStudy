package com.jia.springboot.common.web;
import com.jia.springboot.modules.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by jia on 2018/3/9.
 */
//swagger2注解
@Api(value = "FastJson测试", tags = { "测试接口" })
@Controller
@RequestMapping("fastjson")
public class FastJsonController {
    @RequestMapping("/test")
    @ResponseBody
    /*//细粒度跨域请求注解 jdk1.7用不了此注解
    @CrossOrigin(origins="http://localhost:8089")*/
    public User test() {
        //int x =5/0;
        User user = new User();
        user.setId(1);
        user.setUsername("jack");
        user.setPassword("jack123");
        user.setBirthday(new Date());
        return user;
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
    @GetMapping("/test/{name}")
    public User test(@PathVariable("name") String name) {
        User user = new User();
        user.setId(1);
        user.setUsername(name);
        user.setPassword("jack123");
        user.setBirthday(new Date());
        return user;
    }
}

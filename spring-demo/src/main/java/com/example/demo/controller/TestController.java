package com.example.demo.controller;

import cn.hutool.http.HttpUtil;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: whh
 * @Date: 2020/8/13 18:15
 * @Description:
 */
@Controller
public class TestController {

    public static void main(String[] args) {
        String s = HttpUtil.get("10.10.10.13:8080/test");
        System.out.println(s);
    }

    @Data
    class UserVO{
        private String id;
        private String name;
    }
    @Data
    class UserDTO{
        private UserVO userVO;
        private String [] ids;
        private String [] names;
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return "test";
    }

}
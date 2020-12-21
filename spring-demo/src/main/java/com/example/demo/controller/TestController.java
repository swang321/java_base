package com.example.demo.controller;

import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Controller;

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
}
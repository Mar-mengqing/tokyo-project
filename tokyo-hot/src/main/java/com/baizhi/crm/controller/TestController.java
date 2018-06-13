package com.baizhi.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created with mengqing.
 * Date: 2018/5/25 0025
 * Time: 上午 11:45
 * 职位增删改查. 该类作用
 */
@Controller
public class TestController {
    @RequestMapping("/testPage")
    public String testPage(){
        System.out.println("1111");
        return "test";
    }

    @RequestMapping("/testPage2")
    public String testPage2(){
        System.out.println("1111");
        return "index";
    }
}

package com.nongshanie.generator.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhouxinhang
 * @date: 2018/12/6
 * @Description:    初始化项目测试
 */
@RestController
@RequestMapping("generator")
public class GeneratorController {

    @RequestMapping("success")
    public String generator(){
        System.out.println("generator.................................................");
        return "success";
    }
}

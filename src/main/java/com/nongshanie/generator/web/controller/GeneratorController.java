package com.nongshanie.generator.web.controller;

import com.nongshanie.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhouxinhang
 * @date: 2018/12/6
 * @Description:    初始化项目测试
 */
@Controller
@RequestMapping("generator")
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @RequestMapping("success")
    public String generator(){
        try {
            generatorService.codeGenerator();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("generator.................................................");
        return "success";
    }

    @RequestMapping("ftl")
    public String attachments(Model model) {
        List<String> arrayList = new ArrayList<>(5);
        arrayList.add("xiaoming");
        arrayList.add("xiaochun");
        arrayList.add("xiaobai");
        arrayList.add("nanshen");
        arrayList.add("daming");
        model.addAttribute("ListMap", arrayList);
        return "JsonResult";
    }
}

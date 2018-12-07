package com.nongshanie.generator.web.controller;

import com.nongshanie.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhouxinhang
 * @date: 2018/12/6
 * @Description: 初始化项目测试
 */
@Controller
@RequestMapping("generator")
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @RequestMapping("success")
    @ResponseBody
    public String generator(String url,String port, String userName, String password, String databaseName, String fileDirectory) {
        String resultStr;
        try {
            String jdbcUrl = "jdbc:mysql://"+url+":"+port;
            resultStr = generatorService.codeGenerator(jdbcUrl, userName, password, databaseName, fileDirectory);
        } catch (Exception e) {
            resultStr = "false";
            e.printStackTrace();
        }
        System.out.println("generator................................................." + resultStr);
        return resultStr;
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

package com.nongshanie.generator.web.controller;

import com.nongshanie.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhouxinhang
 * @date: 2018/12/6
 * @Description: 初始化项目测试
 */
@RestController
@RequestMapping("generator")
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @PostMapping("codegenerator")
    public Map<String,String> generator(String url, String port, String userName, String password, String databaseName, String fileDirectory) {
        String resultStr;
        HashMap<String, String> resultMap = new HashMap<>(2);
        try {
            String jdbcUrl = "jdbc:mysql://"+url+":"+port+"?serverTimezone=GMT%2B8";
            resultStr = generatorService.codeGenerator(jdbcUrl, userName, password, databaseName, fileDirectory);
            resultMap.put("status","success");
            resultMap.put("fileDirectory",resultStr);
        } catch (Exception e) {
            resultMap.put("status","false");
            e.printStackTrace();
        }
        return resultMap;
    }
}

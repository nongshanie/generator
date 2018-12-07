package com.nongshanie.generator.utils;


import com.nongshanie.generator.service.MySqlDatebaseService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//代码生成器类
@Component
public class CodeGenerator {
    @Autowired
    private MySqlDatebaseService mySqlDatebaseService;

    private static Configuration cfg;

    static {
        try {
            cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File("D:\\git\\generator\\src\\main\\java\\com\\nongshanie\\generator\\common\\templates"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  String generated(String url,String userName,String password,String databaseName,String fileDirectory) throws Exception {
        Object classInfo = getResultClassInfo(url,userName,password,databaseName);
        createFile(classInfo, "JsonResult.ftl", fileDirectory+"\\xxxxxxxx.java");
        return fileDirectory;
    }

    /**
     * 获取表对象集合
     *
     * @return 表对象集合
     */
    private  Object getResultClassInfo(String url,String userName,String password,String databaseName) throws SQLException {
        Map<String, Object> map = new HashMap<>(5);
        List<String> tableNames = mySqlDatebaseService.getTableNames(url, userName, password, databaseName);
        map.put("ListMap", tableNames);
        return map;
    }


    /**
     * 生成文件
     */
    private  void createFile(Object object, String templateFile, String targetFile) throws Exception {
        Template template = cfg.getTemplate(templateFile);
        File f = new File(targetFile);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        template.process(object, new FileWriter(targetFile));
    }


}

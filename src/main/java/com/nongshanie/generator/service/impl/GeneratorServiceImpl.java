package com.nongshanie.generator.service.impl;

import com.nongshanie.generator.service.GeneratorService;
import com.nongshanie.generator.service.MySqlDatebaseService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhouxinhang
 * @date: 2018/12/6
 * @Description:
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {



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

    /**
     * @return
     * @Author zhouxinhang
     * @Description 用户生成代码
     * @Date 2018/12/6
     */
    @Override
    public String codeGenerator(String url,String userName,String password,String databaseName,String fileDirectory) throws Exception {
        String resultStr = generated(url,userName,password,databaseName,fileDirectory);
        return resultStr;
    }


    public  String generated(String url,String userName,String password,String databaseName,String fileDirectory) throws Exception {
        Object classInfo = getResultClassInfo(url,userName,password,databaseName);
        createFile(classInfo, "JsonResult.ftl", fileDirectory+"\\generatorConfig.xml");
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
        map.put("url", url);
        map.put("userName", userName);
        map.put("password", password);
        map.put("databaseName", databaseName);
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

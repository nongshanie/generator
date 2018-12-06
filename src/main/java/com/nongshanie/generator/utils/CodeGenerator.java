package com.nongshanie.generator.utils;


import freemarker.template.Configuration;
import freemarker.template.Template;
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
    private static Configuration cfg;

    static {
        try {
            cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File("D:\\git\\generator\\src\\main\\java\\com\\nongshanie\\generator\\common\\templates"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void generated() throws Exception {
        Object classInfo = getResultClassInfo();
        createFile(classInfo, "JsonResult.ftl", "D:\\xxxxxxxx.java");
    }

    /**
     * 获取表对象集合
     *
     * @return 表对象集合
     */
    private static Object getResultClassInfo() throws SQLException {
        Map<String, Object> map = new HashMap<>(5);
        List<String> arrayList = new ArrayList<>(5);
        arrayList.add("xiaoming");
        arrayList.add("xiaochun");
        arrayList.add("xiaobai");
        arrayList.add("nanshen");
        arrayList.add("daming");
        map.put("ListMap", arrayList);
        return map;
    }


    /**
     * 生成文件
     */
    private static void createFile(Object object, String templateFile, String targetFile) throws Exception {
        Template template = cfg.getTemplate(templateFile);
        File f = new File(targetFile);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        template.process(object, new FileWriter(targetFile));
    }


}

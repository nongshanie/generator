package com.nongshanie.generator.service;


public interface GeneratorService {

    /**
     * @Author zhouxinhang
     * @Description         用户生成代码
     * @Date 2018/12/6
     * @return
     */
    String codeGenerator(String url,String userName,String password,String databaseName,String fileDirectory) throws Exception;

}

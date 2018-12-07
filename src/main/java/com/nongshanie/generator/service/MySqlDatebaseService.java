package com.nongshanie.generator.service;

import java.util.List;

/**
 * @author: zhouxinhang
 * @date: 2018/12/7
 * @Description:
 */
public interface MySqlDatebaseService {

    List<String> getTableNames(String url,String userName,String password,String datebaseName);
}

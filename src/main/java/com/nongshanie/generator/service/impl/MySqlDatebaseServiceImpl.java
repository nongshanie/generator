package com.nongshanie.generator.service.impl;

import com.nongshanie.generator.service.MySqlDatebaseService;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhouxinhang
 * @date: 2018/12/7
 * @Description: 用于操作mysql数据库
 */
@Service
public class MySqlDatebaseServiceImpl implements MySqlDatebaseService {


    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    @Override
    public List<String> getTableNames(String url, String userName, String password, String datebaseName) {
        ArrayList<String> arrayList = new ArrayList<>(200);
        try {
            // 加载驱动程序
            Class.forName(JDBC_DRIVER);
            // 连续数据库
            Connection conn = DriverManager.getConnection(url, userName, password);

            if (!conn.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
            }
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要执行的SQL语句
            StringBuilder sql = new StringBuilder();
            sql.append("select table_name from information_schema.tables where table_schema='");
            sql.append(datebaseName);
            sql.append("'");
            // 结果集
            ResultSet rs = statement.executeQuery(sql.toString());
            String name;
            while (rs.next()) {
                name = rs.getString("table_name");
                arrayList.add(name);
                System.out.println("name = " + name);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList;
    }
}

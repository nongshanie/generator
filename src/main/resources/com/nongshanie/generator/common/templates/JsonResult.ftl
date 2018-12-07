<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd" >
<generatorConfiguration >
    <classPathEntry  location="D:/repository/mysql/mysql-connector-java/5.1.32/mysql-connector-java-5.1.32.jar"/>
    <context id="context1" >
        <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
        <commentGenerator>
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>
        <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="${url}/${databaseName}?useUnicode=true&amp;characterEncoding=UTF-8&amp;useSSL=false" userId="${userName}" password="${password}" />
        <javaModelGenerator targetPackage="com.xhh.loan.model.entity" targetProject="src/main/java" >
            <property name="enableSubPackages" value="false"/>
            <!-- 是否针对string类型的字段在set的时候进行trim调用 -->
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
        <sqlMapGenerator targetPackage="sqlmapper" targetProject="src/main/resources" >
            <property name="enableSubPackages" value="false"/>
        </sqlMapGenerator>
        <javaClientGenerator targetPackage="com.xhh.loan.model.mapper" targetProject="src/main/java" type="XMLMAPPER" >
            <property name="enableSubPackages" value="false"/>
            <property name="" value=""/>
        </javaClientGenerator>
        <#list ListMap as param>
          <table tableName="${param}" enableCountByExample="false" enableUpdateByExample="false"
                 enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false" >
              <generatedKey column="id" sqlStatement="MySql" identity="true" />
          </table>
        </#list>
    </context>
</generatorConfiguration>

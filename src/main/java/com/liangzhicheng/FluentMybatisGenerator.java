package com.liangzhicheng;

import cn.org.atool.generator.FileGenerator;
import cn.org.atool.generator.annotation.Table;
import cn.org.atool.generator.annotation.Tables;

public class FluentMybatisGenerator {

    public static void main(String[] args) {
        FileGenerator.build(Abc.class);
    }

    @Tables(
            /** 数据库连接信息 **/
            url = "jdbc:mysql://localhost:3306/fluent-mybatis?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai",
            username = "root",
            password = "admin",
            /** Entity类parent package路径 **/
            basePack = "com.liangzhicheng.modules",
            /** Entity代码源目录 **/
            srcDir = "/src/main/java",
            /** Dao代码源目录 **/
            daoDir = "/src/main/java",
            /** 如果表定义记录创建，记录修改，逻辑删除字段 **/
            gmtCreated = "create_time", gmtModified = "update_time", logicDeleted = "is_deleted",
            /** 需要生成文件的表 **/
            tables = @Table(value = {"t_user"})
    )

    static class Abc {

    }

}

package com.zhangshuoyi.myfire.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 项目代码自动生成器
 */
public class MyFireGenerator {

    private static final String URL = "jdbc:mysql://192.168.12.130:3306/firesafety";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "123456";

    /**
     * 实体类父类
     */
    private static final String SUPER_ENTITY_CLASS = "com.zhangshuoyi.myfire.component.db.abstracts.BaseEntity";

    /**
     * 过滤实体类父类的字段
     */
    private static final String[] SUPER_ENTITY_COLUMNS = {
            "remark",
            "create_user",
            "create_time",
            "update_user",
            "update_time",
            "del_flag"
    };

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                // 全局配置
                .globalConfig((scanner, builder) ->
                        builder.author(scanner.apply("请输入作者名称"))
                                .outputDir(scanner.apply("请输入输出目录").concat("\\src\\main\\java")))
                // 包配置
                .packageConfig((scanner, builder) ->
                        builder.parent(scanner.apply("请输入包名"))
                                .entity("domain")
                                .xml("mapper.mapping"))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔")))
                        .serviceBuilder()
                        // 自定义 Service 名称，去掉前面的 I
                        .formatServiceFileName("%sService")
                        .controllerBuilder()
                        .enableRestStyle()
                        .enableHyphenStyle()
                        .entityBuilder()
                        .enableLombok()
                        .superClass(SUPER_ENTITY_CLASS)
                        .addSuperEntityColumns(SUPER_ENTITY_COLUMNS)
                        .build())

                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}

package com.example.springboot3;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot3ApplicationTests {

    private static final String PARENT_DIR = System.getProperty("user.dir");
    /**
     * 基本路径
     */
    private static final String SRC_MAIN_JAVA = "/src/main/java/";
    /**
     * xml路径
     */
    private static final String XML_PATH = PARENT_DIR + "/src/main/resources/mappers";
    /**
     * entity路径
     */
    private static final String ENTITY_PATH = PARENT_DIR +SRC_MAIN_JAVA+ "/com/example/springboot3/entity";
    /**
     * mapper路径
     */
    private static final String MAPPER_PATH = PARENT_DIR +SRC_MAIN_JAVA+ "/com/example/springboot3/mapper";
    /**
     * service路径
     */
    private static final String SERVICE_PATH = PARENT_DIR +SRC_MAIN_JAVA+ "/com/example/springboot3/service";
    /**
     * serviceImpl路径
     */
    private static final String SERVICE_IMPL_PATH = PARENT_DIR +SRC_MAIN_JAVA+ "/com/example/springboot3/service/impl/";
    /**
     * controller路径
     */
    private static final String CONTROLLER_PATH = PARENT_DIR +SRC_MAIN_JAVA+ "/com/example/springboot3/controller";
    /**
     * 数据库url
     */
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test_user_encryptor?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    /**
     * 数据库用户名
     */
    private static final String USERNAME = "root";
    /**
     * 数据库密码
     */
    private static final String PASSWORD = "St@95231";


    public static void main(String[] args) {


        List<String> tables = new ArrayList<>();
        tables.add("sys_user");



//        String preFix = "Sys";

        FastAutoGenerator.create(DB_URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder
                            .author("ZhaoZhongYu") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .disableOpenDir()
//                            .outputDir(System.getProperty("user.dir"))
                            .commentDate("yyyy-MM-dd");
                }).packageConfig(builder -> {
                    builder
                            .parent("") // 设置父包名
                            .entity("com.example.springboot3.entity")
                            .service("com.example.springboot3.service")
                            .serviceImpl("com.example.springboot3.service.impl")
                            .controller("com.example.springboot3.controller")
                            .mapper("com.example.springboot3.mapper")
                            .xml("com.example.springboot3")
                            .pathInfo(getPathInfo()); // 设置mapperXml生成路径
                }).templateConfig(builder -> {
                    builder
                            .disable(TemplateType.ENTITY).entity("/templates/entity.java");
                }).strategyConfig(builder -> {
                    builder
                            .addInclude(tables)
                            // service
                            .serviceBuilder()//service策略配置
                            .enableFileOverride()
                            .superServiceClass(IService.class)
                            .formatServiceFileName("%sService")//service适配，%s适配，根据表明替换
                            .formatServiceImplFileName("%sServiceImpl")//同上
                            //entity
                            .entityBuilder()//实体类策略配置
                            .enableFileOverride()
                            .enableChainModel()
                            .enableFileOverride()
                            .enableLombok()
                            .enableRemoveIsPrefix()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("create_by", FieldFill.INSERT))
                            .addTableFills(new Column("create_by_id", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Column("update_by", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Column("update_by_id", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Column("create_by_dpt", FieldFill.INSERT))
                            .addTableFills(new Column("create_by_dpt_number", FieldFill.INSERT))
                            .addTableFills(new Column("update_by_dpt", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Column("update_by_dpt_number", FieldFill.INSERT_UPDATE))
                            .formatFileName("%sEntity")
                            .enableTableFieldAnnotation()
                            // controller
                            .controllerBuilder()
                            .enableFileOverride()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .enableHyphenStyle()
                            // mapper
                            .mapperBuilder()
                            .enableFileOverride()
                            .enableBaseResultMap()  //生成通用的resultMap
                            .enableBaseColumnList()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
//                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }


    /**
     * 获取路径信息map
     *
     */
    private static Map<OutputFile, String> getPathInfo() {
        Map<OutputFile, String> pathInfo = new HashMap<>(5);
        pathInfo.put(OutputFile.entity, ENTITY_PATH);
        pathInfo.put(OutputFile.mapper, MAPPER_PATH);
        pathInfo.put(OutputFile.service, SERVICE_PATH);
        pathInfo.put(OutputFile.serviceImpl, SERVICE_IMPL_PATH);
        pathInfo.put(OutputFile.controller, CONTROLLER_PATH);
        pathInfo.put(OutputFile.xml, XML_PATH);
        return pathInfo;
    }




}

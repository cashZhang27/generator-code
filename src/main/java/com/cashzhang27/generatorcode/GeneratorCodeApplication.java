package com.cashzhang27.generatorcode;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the generator code startup class.
 *
 * @author Cash Zhang
 * @version v1.0
 * @since 2020/03/18 21:47
 */
public class GeneratorCodeApplication {

  public static String[] includeTableName = new String[] {"client"};
  public static String version = "v1.0";
  public static String dbHost = "localhost";
  public static String database = "test";
  public static String username = "root";
  public static String password = "root";

  public static String parentPackage = "com.cashzhang27.bisme.web";
  public static String superServiceClass = "com.cashzhang27.bisme.web.base.service.SuperService";
  public static String superServiceImplClass =
      "com.cashzhang27.bisme.web.base.service.impl.SuperServiceImpl";
  public static String superEntityClass =
      "com.cashzhang27.bisme.web.base.entity.SuperEntity";
  public static String superMapperClass = "com.cashzhang27.bisme.web.base.mapper.SuperMapper";
  /**
   * main function.
   *
   * @param args args
   */
  public static void main(String[] args) {

    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir(projectPath + "/src/main/java");
    gc.setAuthor("Cash Zhang");
    gc.setOpen(false);
    // 实体属性 Swagger2 注解
    gc.setSwagger2(true);
    gc.setServiceName("%sService");
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(
        "jdbc:mysql://"
            + dbHost
            + ":3306/"
            + database
            + "?characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername(username);
    dsc.setPassword(password);
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setParent(parentPackage);
    mpg.setPackageInfo(pc);
    // 自定义配置
    InjectionConfig cfg =
        new InjectionConfig() {
          @Override
          public void initMap() {
            Map<String, Object> map = new HashMap<>();
            map.put("version", version);
            map.put(
                "currentDate",
                LocalDateTime.now()
                    .atZone(ZoneId.of("Asia/Shanghai"))
                    .format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            this.setMap(map);
          }
        };

    String templatePath = "/templates/mapper.xml.ftl";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(
        new FileOutConfig(templatePath) {
          @Override
          public String outputFile(TableInfo tableInfo) {
            // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
            return projectPath
                + "/src/main/resources/mapper/"
                + tableInfo.getEntityName()
                + "Mapper"
                + StringPool.DOT_XML;
          }
        });
    /*
    cfg.setFileCreate(new IFileCreate() {
        @Override
        public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
            // 判断自定义文件夹是否需要创建
            checkDir("调用默认方法创建的目录");
            return false;
        }
    });
    */
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    templateConfig.setEntity("templates/entity.java");
    templateConfig.setService("templates/service.java");
    templateConfig.setServiceImpl("templates/serviceImpl.java");
    templateConfig.setController("templates/controller.java");
    templateConfig.setMapper("templates/mapper.java");

    templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setSuperServiceClass(superServiceClass);
    strategy.setSuperServiceImplClass(superServiceImplClass);
    strategy.setSuperEntityClass(superEntityClass);
    strategy.setSuperMapperClass(superMapperClass);
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    strategy.setEntitySerialVersionUID(false);

    strategy.setInclude(includeTableName);
    strategy.setControllerMappingHyphenStyle(true);
    mpg.setStrategy(strategy);
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();
  }
}

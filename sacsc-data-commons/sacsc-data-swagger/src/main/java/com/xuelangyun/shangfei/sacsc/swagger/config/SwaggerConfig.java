package com.xuelangyun.shangfei.sacsc.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 *
 * @author moyan.zk
 * @createTime 2022年03月29日 16:54:00
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Value("${spring.application.name:}")
  private String applicationName;

  @Value("${swagger.title:}")
  private String title;

  @Value("${swagger.description:}")
  private String description;

  @Value("${swagger.version:}")
  private String version;

  @Value("${swagger.license:}")
  private String license;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName(applicationName)
        // 控制哪些接口加入文档
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.xuelangyun.shangfei"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(webApiInfo());
  }

  /**
   * 创建接口文档的具体信息，会显示在接口文档页面中
   *
   * @return
   */
  private ApiInfo webApiInfo() {
    return new ApiInfoBuilder()
        // 文档标题
        .title(title)
        // 文档描述
        .description(description)
        // 版本
        .version(version)
        // 联系人信息
        .contact(new Contact("雪浪云", "https://www.xuelangyun.com/#/", "xuelangyun@xuelangyun.com"))
        // 版权
        .license(license)
        // 版权地址
        .licenseUrl("https://www.xuelangyun.com")
        .build();
  }
}

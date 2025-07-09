package com.xuelangyun.shangfei.sacsc.datasource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author warhin
 * @date 2024/6/19 19:58
 */
@Configuration
@EnableTransactionManagement
@MapperScan(
    basePackages = {
      "com.xuelangyun.shangfei.sacsc.datasource.mapper*",
      "com.xuelangyun.shangfei.sacsc.datasource.*.mapper*"
    })
public class DatasourceConfig {}

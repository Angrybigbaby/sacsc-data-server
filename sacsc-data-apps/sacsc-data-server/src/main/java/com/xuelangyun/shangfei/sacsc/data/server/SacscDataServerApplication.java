package com.xuelangyun.shangfei.sacsc.data.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"com.xuelangyun.shangfei.sacsc"})
@EnableScheduling
@MapperScan(basePackages = "com.xuelangyun.shangfei.sacsc.datasource.mapper")
@EnableTransactionManagement
@ServletComponentScan(basePackages = {"com.xuelangyun.shangfei.sacsc.data.server.web.filter"})
public class SacscDataServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SacscDataServerApplication.class, args);
  }
}

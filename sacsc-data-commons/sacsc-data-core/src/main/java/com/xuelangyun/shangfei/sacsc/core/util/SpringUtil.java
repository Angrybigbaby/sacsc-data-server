package com.xuelangyun.shangfei.sacsc.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/** @Auther: zigui.zdf @Date: 2018/10/16 21:41 @Description: */
@Configuration
public class SpringUtil implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    if (SpringUtil.applicationContext == null) {
      SpringUtil.applicationContext = applicationContext;
    }
  }

  // 获取applicationContext
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  // 通过name获取 Bean.
  public static Object getBean(String name) {
    return getApplicationContext().getBean(name);
  }

  // 通过class获取Bean.
  public static <T> T getBean(Class<T> clazz) {
    return getApplicationContext().getBean(clazz);
  }

  // 通过name,以及Clazz返回指定的Bean
  public static <T> T getBean(String name, Class<T> clazz) {
    return getApplicationContext().getBean(name, clazz);
  }
}

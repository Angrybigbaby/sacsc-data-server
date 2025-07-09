package com.xuelangyun.shangfei.sacsc.datasource.base;

import tk.mybatis.mapper.annotation.Version;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/** Create by huaying.ll on 11/27/2020 */
public class MySqlHelper extends SqlHelper {

  public static String getAllIfColumns(Class<?> entityClass, boolean empty, boolean useVersion) {
    StringBuilder sql = new StringBuilder();
    sql.append("<where>");
    sql.append(" 1=1 ");
    // 获取全部列
    Set<EntityColumn> columnSet = EntityHelper.getColumns(entityClass);
    // 当某个列有主键策略时，不需要考虑他的属性是否为空，因为如果为空，一定会根据主键策略给他生成一个值
    for (EntityColumn column : columnSet) {
      if (!useVersion || !column.getEntityField().isAnnotationPresent(Version.class)) {
        sql.append(getIfNotNull(column, " AND " + column.getColumnEqualsHolder(), empty));
      }
    }
    if (useVersion) {
      sql.append(whereVersion(entityClass));
    }
    sql.append("</where>");
    return sql.toString();
  }
}

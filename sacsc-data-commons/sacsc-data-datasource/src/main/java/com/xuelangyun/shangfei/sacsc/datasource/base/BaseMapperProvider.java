package com.xuelangyun.shangfei.sacsc.datasource.base;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/** Create by huaying.ll on 2020/9/1 */
public class BaseMapperProvider extends MapperTemplate {
  public BaseMapperProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
    super(mapperClass, mapperHelper);
  }

  public String selectMaxCreateTime(MappedStatement ms) {
    Class<?> entityClass = getEntityClass(ms);
    // 修改返回值类型为实体类型
    //  setResultType(ms, entityClass);
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT MAX(`create_time`) ");
    sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
    return sql.toString();
  }

  public String selectMaxCreateTimeByEntity(MappedStatement ms) {
    Class<?> entityClass = getEntityClass(ms);
    // 修改返回值类型为实体类型
    //  setResultType(ms, entityClass);
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT MAX(`create_time`) ");
    sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
    sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
    return sql.toString();
  }

  public String selectMaxCreateTimeByExample(MappedStatement ms) {
    Class<?> entityClass = getEntityClass(ms);
    // 修改返回值类型为实体类型
    //  setResultType(ms, entityClass);
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT MAX(`create_time`) ");
    if (isCheckExampleEntityClass()) {
      sql.append(SqlHelper.exampleCheck(entityClass));
    }
    sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
    sql.append(SqlHelper.exampleWhereClause());
    return sql.toString();
  }

  /**
   * 查询
   *
   * @param ms
   * @return
   */
  public String selectOneMaxEntityByEntity(MappedStatement ms) {
    Class<?> entityClass = getEntityClass(ms);
    // 修改返回值类型为实体类型
    setResultType(ms, entityClass);
    StringBuilder sql = new StringBuilder();
    sql.append(SqlHelper.selectAllColumns(entityClass));
    sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
    sql.append(MySqlHelper.getAllIfColumns(entityClass, isNotEmpty(), false));
    sql.append(" and create_time = (SELECT MAX(`create_time`) ");
    sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
    sql.append(" ) limit 1");
    return sql.toString();
  }

  /**
   * 查询
   *
   * @param ms
   * @return
   */
  public String selectMaxEntityByEntity(MappedStatement ms) {
    Class<?> entityClass = getEntityClass(ms);
    // 修改返回值类型为实体类型
    setResultType(ms, entityClass);
    StringBuilder sql = new StringBuilder();
    sql.append(SqlHelper.selectAllColumns(entityClass));
    sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
    sql.append(MySqlHelper.getAllIfColumns(entityClass, isNotEmpty(), false));
    sql.append(" and create_time = (SELECT MAX(`create_time`) ");
    sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
    sql.append(" ) ");
    sql.append(SqlHelper.orderByDefault(entityClass));
    return sql.toString();
  }

  public String updateBatchByPrimaryKeySelective(MappedStatement ms) {
    final Class<?> entityClass = getEntityClass(ms);
    //开始拼sql
    StringBuilder sql = new StringBuilder();
    sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
    sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");

    //获取全部列
    Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
    for (EntityColumn column : columnList) {
      if (!column.isId() && column.isUpdatable()) {
        sql.append("  <trim prefix=\""+column.getColumn()+" =case\" suffix=\"end,\">");
        sql.append("    <foreach collection=\"list\" item=\"i\" index=\"index\">");
        sql.append("      <if test=\"i."+column.getEntityField().getName()+"!=null\">");
        sql.append("         when id=#{i.id} then #{i."+column.getEntityField().getName()+"}");
        sql.append("      </if>");
        sql.append("    </foreach>");
        sql.append("  </trim>");
      }
    }

    sql.append("</trim>");
    sql.append("WHERE");
    sql.append(" id IN ");
    sql.append("<trim prefix=\"(\" suffix=\")\">");
    sql.append("<foreach collection=\"list\" separator=\", \" item=\"i\" index=\"index\" >");
    sql.append("#{i.id}");
    sql.append("</foreach>");
    sql.append("</trim>");

    return sql.toString();
  }

  public String updateBatchByPrimaryKey(MappedStatement ms) {
    final Class<?> entityClass = getEntityClass(ms);
    //开始拼sql
    StringBuilder sql = new StringBuilder();
    sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
    sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");

    //获取全部列
    Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
    for (EntityColumn column : columnList) {
      if (!column.isId() && column.isUpdatable()) {
        sql.append("  <trim prefix=\""+column.getColumn()+" =case\" suffix=\"end,\">");
        sql.append("    <foreach collection=\"list\" item=\"i\" index=\"index\">");
        sql.append("      when id=#{i.id} then #{i."+column.getEntityField().getName()+"}");
        sql.append("    </foreach>");
        sql.append("  </trim>");
      }
    }

    sql.append("</trim>");
    sql.append("WHERE");
    sql.append(" id IN ");
    sql.append("<trim prefix=\"(\" suffix=\")\">");
    sql.append("<foreach collection=\"list\" separator=\", \" item=\"i\" index=\"index\" >");
    sql.append("#{i.id}");
    sql.append("</foreach>");
    sql.append("</trim>");

    return sql.toString();
  }
}

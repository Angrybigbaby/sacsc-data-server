package com.xuelangyun.shangfei.sacsc.datasource.base;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.Date;
import java.util.List;

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

  @SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
  Date selectMaxCreateTime();

  @SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
  Date selectMaxCreateTimeByEntity(T object);

  @SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
  Date selectMaxCreateTimeByExample(Object example);

  @SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
  T selectOneMaxEntityByEntity(T record);

  @SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
  List<T> selectMaxEntityByEntity(T record);

  @UpdateProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
  int updateBatchByPrimaryKeySelective(List<? extends T> recordList);

  @UpdateProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
  int updateBatchByPrimaryKey(List<? extends T> recordList);
}

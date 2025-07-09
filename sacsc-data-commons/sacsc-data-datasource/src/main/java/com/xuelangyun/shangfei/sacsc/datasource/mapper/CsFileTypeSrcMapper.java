package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsFileTypeSrc;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CsFileTypeSrcMapper extends BaseMapper<CsFileTypeSrc> {

  @Select(
      " select b.src_desc, b.file_url "
          + " from cs_file_type a "
          + " left join cs_file_type_src b on a.id = b.type_id "
          + " where a.type_desc = #{typeDesc} and a.is_valid = 1 and b.is_valid = 1 ")
  List<CsFileTypeSrc> selectByTypeDesc(@Param("typeDesc") final String typeDesc);

  @Select(
      "<script>"
          + " select b.src_desc, b.file_url "
          + " from cs_file_type a "
          + " left join cs_file_type_src b on a.id = b.type_id "
          + " where a.is_valid = 1 and b.is_valid = 1 and a.type_desc in "
          + " <foreach item='typeDesc' index='index' collection='typeDescList' open='(' separator=',' close=')'> "
          + " #{typeDesc} "
          + " </foreach> "
          + "</script>")
  List<CsFileTypeSrc> selectByMultiTypeDesc(@Param("typeDescList") final List<String> typeDescList);
}

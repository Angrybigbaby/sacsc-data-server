package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunAirPlanOverseas;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * @author zijian.qjd
 * @since 2023/3/6 13:32
 */
public interface CsRunAirPlanOverseasMapper extends BaseMapper<CsRunAirPlanOverseas> {

  /**
   * Query flight plans with {@code companyCode} and {@code planMaxTime}.
   *
   * @param companyCode - company unique code.
   * @param planMaxTime - the last time of the data, cannot be null.
   * @return the latest flight plan for {@code companyCode}, if {@code companyCode} is empty, the
   *     result for all company.
   */
  @Select(
      "<script>"
          + " select a.*, b.file_url as companyLogo, c.file_url as companyIcon "
          + " from (select a.*, b.code from cs_run_air_plan_overseas a left join cs_run_company_mark b on a.airline_company = b.company) a "
          + " left join (select a.src_desc, a.file_url, b.code from cs_file_type_src a left join cs_run_company_mark b on a.src_desc = b.company where a.is_valid = 1 and a.type_id = (select id from cs_file_type where is_valid = 1 and type_desc = '航司LOGO' limit 0,1)) b on a.code = b.code "
          + " left join (select a.src_desc, a.file_url, b.code from cs_file_type_src a left join cs_run_company_mark b on a.src_desc = b.company where a.is_valid = 1 and a.type_id = (select id from cs_file_type where is_valid = 1 and type_desc = '航司图标' limit 0,1)) c on a.code = c.code "
          + " where a.create_time = #{planMaxTime} "
          + "<if test='companyCode != null and companyCode.length() > 0'>"
          + "and a.code = #{companyCode}"
          + "</if>"
          + " order by a.dep_plan_time "
          + "</script>")
  List<CsRunAirPlanOverseas> selectWithCompanyAndDay(
      @Param("companyCode") final String companyCode, @Param("planMaxTime") final Date planMaxTime);
}

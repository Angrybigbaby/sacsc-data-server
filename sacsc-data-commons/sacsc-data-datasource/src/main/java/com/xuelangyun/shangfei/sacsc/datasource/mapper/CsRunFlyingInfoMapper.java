package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlyingInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface CsRunFlyingInfoMapper extends BaseMapper<CsRunFlyingInfo> {

  /**
   * 查询4点后降落的飞机（不包含降落过又起飞的）
   *
   * @param date - yyyy-MM-dd 04:00:00
   * @param company -
   * @return -
   */
  List<CsRunFlyingInfo> selectLandAfter4(
      @Param("date") Date date,
      @Param("company") String company,
      @Param("airPlaneLogoDesc") String airPlaneLogoDesc,
      @Param("airPlaneImageDesc") String airPlaneImageDesc,
      @Param("airPlaneLandLogoDesc") String airPlaneLandLogoDesc,
      @Param("model") String model);

  void deleteHistory(@Param("begin") Date begin, @Param("end") Date end);

  @Select(
      "<script>"
          + " select b.file_url as airPlaneLogo, c.file_url as airCompanyLogo, d.file_url as airPlaneImage, a.* "
          + " from (select * from cs_run_flying_info where create_time = #{createTime}"
          + " <if test='company != null and company.length() > 0'> "
          + " and company = #{company} "
          + " </if> "
          + " <if test='model != null and model.length() > 0'> "
          + " and model like #{model} "
          + " </if> "
          + " ) a "
          + " left join ( select src_desc, file_url from cs_file_type_src where is_valid = 1 and type_id = (select id from cs_file_type where type_desc = #{airPlaneLogoDesc} limit 1)) b on a.company = b.src_desc "
          + " left join ( select src_desc, file_url from cs_file_type_src where is_valid = 1 and type_id = (select id from cs_file_type where type_desc = '航司LOGO' limit 1)) c on a.company = c.src_desc "
          + " left join ( select src_desc, file_url from cs_file_type_src where is_valid = 1 and type_id = (select id from cs_file_type where type_desc = #{airPlaneImageDesc} limit 1)) d on a.company = d.src_desc"
          + "</script>")
  List<CsRunFlyingInfo> selectWithImage(
      @Param("company") String company,
      @Param("airPlaneLogoDesc") String airPlaneLogoDesc,
      @Param("airPlaneImageDesc") String airPlaneImageDesc,
      @Param("model") String model,
      @Param("createTime") Date createTime);

  @Select(
      "<script>"
          + " select "
          + "   b.file_url as airPlaneLogo, "
          + "   c.file_url as airCompanyLogo, "
          + "   d.fleet_no as fleetNo, "
          + "   DATE_FORMAT(str_to_date(d.delivery_date, '%Y年%m月%d日'), '%Y-%m-%d') as deliveryTime, "
          + "   a.firstflyTime as firstflytime, a.sysTime as systime, a.offtimeTemp as offtimetemp, a.create_time as createTime, a.* "
          + " from (select * from cs_run_flying_info where create_time = #{createTime}"
          + " <if test='model != null and model.length() > 0'> "
          + " and model like #{model} "
          + " </if> "
          + " ) a "
          + " left join ( select src_desc, file_url from cs_file_type_src where is_valid = 1 and type_id = (select id from cs_file_type where type_desc = #{airPlaneLogoDesc} limit 1)) b on a.company = b.src_desc "
          + " left join ( select src_desc, file_url from cs_file_type_src where is_valid = 1 and type_id = (select id from cs_file_type where type_desc = '航司LOGO' limit 1)) c on a.company = c.src_desc "
          + " left join ( select * from ads_mbl_aircraft_delivery_info where dimension_type = 'airline' ) d on a.tailnumber = SUBSTRING_INDEX(d.plane_reg_serial, '(', 1)"
          + "</script>")
  List<CsRunFlyingInfo> selectWithDeliverInfo(
      @Param("airPlaneLogoDesc") String airPlaneLogoDesc,
      @Param("model") String model,
      @Param("createTime") Date createTime);
}

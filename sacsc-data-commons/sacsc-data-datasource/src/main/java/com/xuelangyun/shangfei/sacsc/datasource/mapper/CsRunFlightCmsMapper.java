package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightCms;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CsRunFlightCmsMapper extends BaseMapper<CsRunFlightCms> {
  /**
   * 根据时间查询每个航班的最新cms数据
   *
   * @param begin -
   * @param end -
   * @param companyNames -
   * @return -
   */
  List<CsRunFlightCms> selectEachFlightNewestByTime(
      @Param("begin") Date begin, @Param("end") Date end, @Param("companyNames") List<String> companyNames);

  /**
   * 查询每架飞机降落之后最新的cas数据
   *
   * @param date -
   * @param company -
   * @return -
   */
  List<CsRunFlightCms> selectEachTailNumberLand(@Param("date") Date date, @Param("company") String company);

  void deleteHistory(@Param("begin") Date begin, @Param("end") Date end);
}

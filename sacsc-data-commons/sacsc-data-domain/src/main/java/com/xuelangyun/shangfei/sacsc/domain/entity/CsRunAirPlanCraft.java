package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2022/2/22 14:57
 */
@Data
@Table(name = "cs_run_air_plan_craft")
public class CsRunAirPlanCraft {
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  @Column(name = "craft_type")
  private String craftType;

  @Column(name = "create_time")
  private Date createTime;
}

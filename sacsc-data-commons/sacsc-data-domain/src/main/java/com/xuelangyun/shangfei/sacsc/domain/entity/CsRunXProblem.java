package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_x_problem")
public class CsRunXProblem {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 年-月 */
  @Column(name = "stat_date")
  private String statDate;

  /** 累计报送总数 */
  @Column(name = "total_amount")
  private Integer totalAmount;

  /** 已达4星以上数 */
  @Column(name = "four_amount")
  private Integer fourAmount;

  @Column(name = "create_time")
  private Date createTime;
}

package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "flywin_sales_type_proportion")
public class FlywinSalesTypeProportion {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 销售类别 */
  @Column(name = "sales_type")
  private String salesType;

  /** 占比(%) */
  private Double proportion;

  @Column(name = "create_time")
  private Date createTime;
}

package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "flywin_sales_profile")
public class FlywinSalesProfile {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 总订单(笔) */
  @Column(name = "total_order")
  private Integer totalOrder;

  /** 总金额(万元) */
  @Column(name = "total_amount")
  private Double totalAmount;

  /** 询价单数(笔) */
  @Column(name = "total_inquiry")
  private Integer totalInquiry;

  @Column(name = "create_time")
  private Date createTime;
}

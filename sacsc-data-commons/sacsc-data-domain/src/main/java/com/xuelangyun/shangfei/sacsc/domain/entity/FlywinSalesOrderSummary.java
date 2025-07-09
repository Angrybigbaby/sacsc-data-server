package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "flywin_sales_order_summary")
public class FlywinSalesOrderSummary {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "total_order_quantity")
  private Integer totalOrderQuantity;

  @Column(name = "order_amount")
  private Double orderAmount;

  @Column(name = "complete_order_quantity")
  private Integer completeOrderQuantity;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private BigDecimal completeRate;
}

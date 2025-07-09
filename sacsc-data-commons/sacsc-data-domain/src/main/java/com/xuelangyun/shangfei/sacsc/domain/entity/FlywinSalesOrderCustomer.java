package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "flywin_sales_order_customer")
public class FlywinSalesOrderCustomer {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 客户类别 */
  @Column(name = "cus_type")
  private String cusType;

  /** 订单量(笔) */
  @Column(name = "order_quantity")
  private Integer orderQuantity;

  /** 金额(万元) */
  @Column(name = "order_amount")
  private Double orderAmount;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private BigDecimal amountRate;
}

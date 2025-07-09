package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "flywin_sales_top")
public class FlywinSalesTop {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航材件号 */
  @Column(name = "part_no")
  private String partNo;

  /** 航材名称 */
  @Column(name = "part_name")
  private String partName;

  /** 订单数量 */
  @Column(name = "order_quantity")
  private Integer orderQuantity;

  /** 订单金额 */
  @Column(name = "order_amount")
  private Double orderAmount;

  @Column(name = "create_time")
  private Date createTime;
}

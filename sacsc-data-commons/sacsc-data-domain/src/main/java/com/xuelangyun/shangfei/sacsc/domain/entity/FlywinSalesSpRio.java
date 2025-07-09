package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "flywin_sales_sp_rio")
public class FlywinSalesSpRio {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 订单编号 */
  @Column(name = "order_no")
  private String orderNo;

  /** 订单名称 */
  @Column(name = "order_name")
  private String orderName;

  /** 订单时间 */
  @Column(name = "order_time")
  @JsonFormat(pattern = "MM-dd")
  private Date orderTime;

  /** 订单分类 */
  @Column(name = "order_type")
  private String orderType;

  /** 订单状态 */
  @Column(name = "order_status")
  private String orderStatus;

  /** 预计完成时间 */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "plane_complete_date")
  private Date planeCompleteDate;

  /** 订单内容,逗号隔开 */
  @Column(name = "order_content")
  private String orderContent;

  /** 订单总零件数 */
  @Column(name = "order_quantity")
  private Integer orderQuantity;

  /** 订单总金额(万元) */
  @Column(name = "order_amount")
  private Double orderAmount;

  /** 客户 */
  @Column(name = "air_company")
  private String airCompany;

  /** 客户地址经度 */
  private Double longitude;

  /** 客户地址纬度 */
  private Double latitude;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private List logistics;

  @Transient private Double fromLongitude = 121.457936;

  @Transient private Double fromLatitude = 31.022427;
}

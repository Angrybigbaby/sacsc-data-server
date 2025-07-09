package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "flywin_sales_sp_rio_logi")
public class FlywinSalesSpRioLogi {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 订单编号 */
  @Column(name = "order_num")
  private String orderNum;

  /** 物流编号 */
  @Column(name = "exp_number")
  private String expNumber;

  /** 物流类型 */
  @Column(name = "exp_type")
  private String expType;

  /** 物流名称 */
  @Column(name = "exp_name")
  private String expName;

  /** 物流官网 */
  @Column(name = "exp_site")
  private String expSite;

  /** 物流官方电话 */
  @Column(name = "exp_phone")
  private String expPhone;

  /** 物流logo */
  @Column(name = "exp_logo")
  private String expLogo;

  /** 邮寄状态 0：快递收件(揽件)1.在途中 2.正在派件 3.已签收 4.派送失败 5.疑难件 6.退件签收 */
  @Column(name = "delivery_status")
  private Integer deliveryStatus;

  /** 是否签收0=否,1=是 */
  @Column(name = "is_sign")
  private Integer isSign;

  /** 快递员 */
  private String courier;

  /** 快递员电话 */
  @Column(name = "courier_phone")
  private String courierPhone;

  /** 更新时间 */
  @Column(name = "update_time")
  private Date updateTime;

  /** 花耗时间 */
  @Column(name = "take_time")
  private String takeTime;

  /** 合同号 */
  @Column(name = "contract_num")
  private String contractNum;

  /** 订单类型 */
  @Column(name = "business_type")
  private String businessType;

  @Column(name = "source_num")
  private String sourceNum;

  @Column(name = "uap_flag")
  private String uapFlag;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private List<FlywinSalesSpRioLogiInfo> logiList;
}

package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "flywin_sales_sp_rio_logi_info")
public class FlywinSalesSpRioLogiInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 物流编号 */
  @Column(name = "logi_id")
  private Long logiId;

  /** 订单编号 */
  @Column(name = "order_num")
  private String orderNum;

  /** 物流编号 */
  @Column(name = "exp_number")
  private String expNumber;

  /** 物流状态 */
  @Column(name = "logi_info")
  private String logiInfo;

  /** 物流时间点 */
  @Column(name = "logi_time")
  private Date logiTime;

  /** 物流备注 */
  @Column(name = "logi_remark")
  private String logiRemark;

  @Column(name = "create_time")
  private Date createTime;
}

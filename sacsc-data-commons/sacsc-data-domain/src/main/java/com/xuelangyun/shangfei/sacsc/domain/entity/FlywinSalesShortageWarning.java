package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Data
@Table(name = "flywin_sales_shortage_warning")
public class FlywinSalesShortageWarning {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 零件号 */
  @Column(name = "part_no")
  private String partNo;

  /** 零件名称 */
  @Column(name = "part_name")
  private String partName;

  /** 剩余库存数 */
  @Column(name = "stock_number")
  private Integer stockNumber;

  /** 需求库存数 */
  @Column(name = "required_stock_number")
  private Integer requiredStockNumber;

  /** 剩余时间/天 */
  @Column(name = "remain_date")
  private Date remainDate;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private Long remainDay;

  public Long getRemainDay() {
    Instant instant = getRemainDate().toInstant();
    ZoneId zoneId = ZoneId.systemDefault();
    LocalDate localDate = instant.atZone(zoneId).toLocalDate();
    long until = LocalDate.now().until(localDate, ChronoUnit.DAYS);
    if (until < 0) {
      until = 0;
    }
    return until;
  }
}

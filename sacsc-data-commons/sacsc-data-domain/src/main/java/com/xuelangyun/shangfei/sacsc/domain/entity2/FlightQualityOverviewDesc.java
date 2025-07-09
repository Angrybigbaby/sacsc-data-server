package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021-11-25 09:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ads_mbl_flight_quality_overview_desc")
public class FlightQualityOverviewDesc {

  @Id
  @Column(name = "date_date")
  private String dateDate;

  @Column(name = "overview_desc")
  private String overviewDesc;

  @Column(name = "system_time")
  private Date systemTime;

  @Column(name = "event_flag")
  private String eventFlag;

  /** 0未发送 1已发送 */
  @Column(name = "msg_send_flag")
  private String msgSendFlag;
}

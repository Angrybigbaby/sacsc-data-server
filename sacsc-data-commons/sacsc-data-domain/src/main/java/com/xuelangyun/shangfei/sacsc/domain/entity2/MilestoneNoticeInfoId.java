package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zijian.qjd
 * @since 2022/3/3 13:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilestoneNoticeInfoId implements Serializable {
  private String warningDate;
  private String eventName;
}

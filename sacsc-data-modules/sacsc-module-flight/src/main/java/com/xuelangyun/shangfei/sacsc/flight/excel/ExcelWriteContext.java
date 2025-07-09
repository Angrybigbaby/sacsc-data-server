package com.xuelangyun.shangfei.sacsc.flight.excel;

import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Font;

/**
 * @author zijian.qjd
 * @since 2023/7/26 17:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExcelWriteContext {

  private int startIndex;
  private String row0Content;
  private Font modelTitleFont;
  private Font statisticFont;
  private FlightPlanData planData;
  private boolean today;
}

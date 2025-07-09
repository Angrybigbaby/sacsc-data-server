package com.xuelangyun.shangfei.sacsc.flight.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xuelangyun.shangfei.sacsc.core.util.DateUtil;
import lombok.Data;

import java.util.List;

/**
 * @author zijian.qjd
 * @since 2023/6/14 10:11
 */
@Data
public class FlightPlanVO {

  private String dataChangeDateTime;
  private String flightYear;
  private String flightMonth;
  private String flightDay;

  private FlightPlanData arj21;
  private FlightPlanData c919;

  @Data
  public static class FlightPlanData {

    /** 执飞飞机总数 */
    private Integer flyPlaneNum;

    /** 执飞航段总数 */
    private Integer flyLegNum;

    /** 机队总数 */
    private Integer fleetNum;

    private List<FlightPlanCompanyGroup> companyFlightPlans;
  }

  @Data
  public static class FlightPlanCompanyGroup {

    private String company;

    private String companyLogo;

    private String airlineThreeCode;

    /** 执飞飞机数 */
    private Integer flyPlaneNum;

    /** 执飞航段数 */
    private Integer flyLegNum;

    /** 机队数 */
    private Integer fleetNum;

    private List<FlightPlanAircraftNoGroup> aircraftNoFlightPlans;
  }

  @Data
  public static class FlightPlanAircraftNoGroup {

    /** 机号 */
    private String aircraftNo;

    /** 架次 */
    private String msn;

    private List<FlightPlanItem> flightPlans;
  }

  @Data
  public static class FlightPlanItem {

    private String no;

    private String noWithCompany;

    /** 机型 */
    private String aircraftType;

    /** 机号 */
    private String aircraftNo;

    /** 架次号 */
    private String msn;

    /** 航班号 */
    private String flightNo;

    /** 状态 */
    private String state;

    /** 性质 */
    private String serviceType;

    /** 起飞机场 */
    private String depAirport;

    /** 起飞机场四字码 */
    private String depFourCode;

    /** 计划起飞 */
    private String depPlanTime;

    /** 实际起飞时间 */
    private String depActTime;

    /** 到达机场 */
    private String arrAirport;

    /** 到达机场四字码 */
    private String arrFourCode;

    /** 计划到达 */
    private String arrPlanTime;

    /** 实际到达时间 */
    private String arrActTime;

    /** 航空公司 */
    private String company;

    /** 航司三字码 */
    private String airlineThreeCode;

    public String getDepPlanTime() {
      return DateUtil.StrToFormatDataStr(depPlanTime, "yyyy-MM-dd HH:mm:ss", "HH:mm");
    }

    public String getDepActTime() {
      return DateUtil.StrToFormatDataStr(depActTime, "yyyy-MM-dd HH:mm:ss", "HH:mm");
    }

    public String getArrPlanTime() {
      return DateUtil.StrToFormatDataStr(arrPlanTime, "yyyy-MM-dd HH:mm:ss", "HH:mm");
    }

    public String getArrActTime() {
      return DateUtil.StrToFormatDataStr(arrActTime, "yyyy-MM-dd HH:mm:ss", "HH:mm");
    }

    // ===

    @JsonIgnore
    public String getOriginDepPlanTime() {
      return this.depPlanTime;
    }

    @JsonIgnore
    public String getOriginDepActTime() {
      return this.depActTime;
    }

    @JsonIgnore
    public String getOriginArrPlanTime() {
      return this.arrPlanTime;
    }

    @JsonIgnore
    public String getOriginArrActTime() {
      return this.arrPlanTime;
    }
  }
}

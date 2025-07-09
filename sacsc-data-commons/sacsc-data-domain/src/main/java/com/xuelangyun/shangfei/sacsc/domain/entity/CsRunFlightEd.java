package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "cs_run_flight_ed")
public class CsRunFlightEd {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航段id */
  private Long flightid;

  /** N1转速L */
  @Column(name = "n1_speed_selected_l")
  private Double n1SpeedSelectedL;

  /** 客舱高度变化率 */
  private Double caltrate;

  /** N1SpeedRedLineR-N1转速红线值R */
  @Column(name = "n1_speed_redline_r")
  private Double n1SpeedRedlineR;

  /** N1振动值R */
  @Column(name = "n1_vib_selected_r")
  private Double n1VibSelectedR;

  /** N1SpeedDemandR-N1指令转速R */
  @Column(name = "n1_speed_demand_r")
  private Double n1SpeedDemandR;

  /** CABDIFPR-客舱压差 */
  private Double cabdifpr;

  /** N1SpeedRedLineL-N1转速红线值L */
  @Column(name = "n1_speed_redline_l")
  private Double n1SpeedRedlineL;

  /** CABINALT-客舱高度 */
  private Double cabinalt;

  /** ITTNorLmtAmbL-ITT温度正常限值(琥珀线)L */
  @Column(name = "itt_norlmtamb_l")
  private Double ittNorlmtambL;

  /** N2振动值L */
  @Column(name = "n2_vib_selected_l")
  private Double n2VibSelectedL;

  /** ITTMaxLmtRedR-ITT最大限值(红线)R */
  @Column(name = "itt_maxlmt_red_r")
  private Double ittMaxlmtRedR;

  /** ITTMaxLmtRedL-ITT最大限值(红线)L */
  @Column(name = "itt_maxlmt_red_l")
  private Double ittMaxlmtRedL;

  /** APUEGT-APU排气温度 */
  @Column(name = "apu_egt")
  private String apuEgt;

  /** 发动机滑油压力L */
  @Column(name = "oil_pressure_l")
  private Double oilPressureL;

  /** N2转速R */
  @Column(name = "n2_speed_selected_r")
  private Double n2SpeedSelectedR;

  /** 发动机滑油温度L */
  @Column(name = "eng_oil_temp_l")
  private Double engOilTempL;

  /** N1SpeedReferenceR-N1基准转速R */
  @Column(name = "n1_speed_reference_r")
  private Double n1SpeedReferenceR;

  /** N2SpeedRedLineR-N2转速红线值R */
  @Column(name = "n2_speed_redline_r")
  private Double n2SpeedRedlineR;

  /** N1转速R */
  @Column(name = "n1_speed_selected_r")
  private Double n1SpeedSelectedR;

  /** N2转速L */
  @Column(name = "n2_speed_selected_l")
  private Double n2SpeedSelectedL;

  /** 涡轮级间温度L */
  @Column(name = "itt_selected_l")
  private Double ittSelectedL;

  /** 右侧油量 */
  private Double fobkgrw;

  /** 发动机滑油压力R */
  @Column(name = "oil_pressure_r")
  private Double oilPressureR;

  /** 1振动值L */
  @Column(name = "n1_vib_selected_l")
  private Double n1VibSelectedL;

  /** 发动机滑油温度R */
  @Column(name = "eng_oil_temp_r")
  private Double engOilTempR;

  /** N2SpeedRedLineL-N2转速红线值L */
  @Column(name = "n2_speed_redline_l")
  private Double n2SpeedRedlineL;

  /** 左侧油量 */
  private Double fobkglw;

  /** APU转速 */
  @Column(name = "apu_speed")
  private Double apuSpeed;

  /** FFL-燃油流量(Fuel Flow)L */
  @Column(name = "fuel_flow_l")
  private Double fuelFlowL;

  /** N1SpeedDemandL-N1指令转速L */
  @Column(name = "n1_speed_demand_l")
  private Double n1SpeedDemandL;

  /** ITTNorLmtAmbR-ITT温度正常限值(琥珀线)R */
  @Column(name = "itt_norlmtamb_r")
  private Double ittNorlmtambR;

  /** N2振动值R */
  @Column(name = "n2_vib_selected_r")
  private Double n2VibSelectedR;

  /** FFR-燃油流量(Fuel Flow)R */
  @Column(name = "itt_selected_r")
  private Double ittSelectedR;

  /** 燃油流量(Fuel Flow)R */
  @Column(name = "fuel_flow_r")
  private Double fuelFlowR;

  /** N1SpeedReferenceL-N1基准转速L" */
  @Column(name = "n1_speed_reference_l")
  private Double n1SpeedReferenceL;

  @Column(name = "create_time")
  private Date createTime;

  private String tailnumber;

  private String msn;

  @Transient private Double fobkgw;
}

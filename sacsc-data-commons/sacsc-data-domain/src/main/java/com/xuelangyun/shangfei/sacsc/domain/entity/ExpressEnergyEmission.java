package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_energy_emission")
public class ExpressEnergyEmission {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  private String model;

  /** 计划量(kg) */
  @Column(name = "fuel_quantity_plan")
  private Double fuelQuantityPlan;

  /** 实际量(kg) */
  @Column(name = "fuel_quantity_actual")
  private Double fuelQuantityActual;

  /** 节约量(kg) */
  @Column(name = "fuel_quantity_save")
  private Double fuelQuantitySave;

  /** 减排前(m³) */
  @Column(name = "emissions_before")
  private Double emissionsBefore;

  /** 减排后(m³) */
  @Column(name = "emissions_after")
  private Double emissionsAfter;

  /** 减排量(m³) */
  @Column(name = "emissions_save")
  private Double emissionsSave;

  /** 降噪前(dB) */
  @Column(name = "noise_before")
  private Double noiseBefore;

  /** 降噪后(dB) */
  @Column(name = "noise_after")
  private Double noiseAfter;

  /** 降噪量(dB) */
  @Column(name = "noise_save")
  private Double noiseSave;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;

  public ExpressEnergyEmission() {};

  public ExpressEnergyEmission(
      Double fuelQuantityPlan,
      Double fuelQuantityActual,
      Double fuelQuantitySave,
      Double emissionsBefore,
      Double emissionsAfter,
      Double emissionsSave,
      Double noiseBefore,
      Double noiseAfter,
      Double noiseSave) {
    this.fuelQuantityPlan = fuelQuantityPlan;
    this.fuelQuantityActual = fuelQuantityActual;
    this.fuelQuantitySave = fuelQuantitySave;
    this.emissionsBefore = emissionsBefore;
    this.emissionsAfter = emissionsAfter;
    this.emissionsSave = emissionsSave;
    this.noiseBefore = noiseBefore;
    this.noiseAfter = noiseAfter;
    this.noiseSave = noiseSave;
  }
}

package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "express_poi_airport")
public class ExpressPoiAirport {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机场名称 */
  private String name;

  /** 风速(m/s) */
  @Column(name = "wind_speed")
  private String windSpeed;

  /** 风向 */
  @Column(name = "wind_direction")
  private String windDirection;

  /** 温度℃ */
  private String temperature;

  /** 湿度(%) */
  private String humidity;

  /** 天气标志 */
  @Column(name = "weather_flag")
  private String weatherFlag;

  @Column(name = "create_time")
  private Date createTime;

  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  /** @return id */
  public Long getId() {
    return id;
  }

  /** @param id */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取机场名称
   *
   * @return name - 机场名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置机场名称
   *
   * @param name 机场名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取风速(m/s)
   *
   * @return wind_speed - 风速(m/s)
   */
  public String getWindSpeed() {
    return windSpeed;
  }

  /**
   * 设置风速(m/s)
   *
   * @param windSpeed 风速(m/s)
   */
  public void setWindSpeed(String windSpeed) {
    this.windSpeed = windSpeed;
  }

  /**
   * 获取风向
   *
   * @return wind_direction - 风向
   */
  public String getWindDirection() {
    return windDirection;
  }

  /**
   * 设置风向
   *
   * @param windDirection 风向
   */
  public void setWindDirection(String windDirection) {
    this.windDirection = windDirection;
  }

  /**
   * 获取温度℃
   *
   * @return temperature - 温度℃
   */
  public String getTemperature() {
    return temperature;
  }

  /**
   * 设置温度℃
   *
   * @param temperature 温度℃
   */
  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  /**
   * 获取湿度(%)
   *
   * @return humidity - 湿度(%)
   */
  public String getHumidity() {
    return humidity;
  }

  /**
   * 设置湿度(%)
   *
   * @param humidity 湿度(%)
   */
  public void setHumidity(String humidity) {
    this.humidity = humidity;
  }

  /**
   * 获取天气标志
   *
   * @return weather_flag - 天气标志
   */
  public String getWeatherFlag() {
    return weatherFlag;
  }

  /**
   * 设置天气标志
   *
   * @param weatherFlag 天气标志
   */
  public void setWeatherFlag(String weatherFlag) {
    this.weatherFlag = weatherFlag;
  }

  /** @return create_time */
  public Date getCreateTime() {
    return createTime;
  }

  /** @param createTime */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}

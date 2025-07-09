package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * @author zijian.qjd
 */
@Builder
@Data
@Accessors(chain = true)
@Table(name = "tb_employee")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "mobile")
  private String mobile;

  @Column(name = "card_no")
  private String cardNo;

  @Column(name = "sf_user_id")
  private Integer sfUserId;

  @Column(name = "userUniId")
  private String userUniId;

  @Column(name = "directly_sf_dep_id")
  private Integer directlyDepId;

  @Column(name = "level1_sf_dep_id")
  private Integer level1SfDepId;

  @Column(name = "subsidiary_sf_id")
  private Integer subsidiarySfId;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "last_modified_time")
  private Date modifiedTime;

  @Override
  public int hashCode() {
    return Objects.hash(name, mobile, cardNo, sfUserId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (Objects.isNull(obj)) {
      return false;
    }
    if (obj instanceof EmployeeModel) {
      EmployeeModel other = (EmployeeModel) obj;
      if (Objects.equals(this.getName(), other.getName())
          && Objects.equals(this.getMobile(), other.getMobile())
          && Objects.equals(this.getCardNo(), other.getCardNo())
          && Objects.equals(this.getSfUserId(), other.getSfUserId())) {
        return true;
      }
    }
    return false;
  }
}

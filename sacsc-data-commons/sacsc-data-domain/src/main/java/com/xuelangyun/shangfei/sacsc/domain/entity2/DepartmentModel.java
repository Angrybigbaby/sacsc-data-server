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
@Table(name = "tb_department")
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentModel {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "parent_id")
  private Long parentId;

  @Column(name = "sf_dep_id")
  private Integer sfDepId;

  @Column(name = "name")
  private String name;

  @Column(name = "path")
  private String path;

  @Column(name = "code")
  private String code;

  @Column(name = "structUniId")
  private String structUniId;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "last_modified_time")
  private Date modifiedTime;

  @Override
  public int hashCode() {
    return Objects.hash(parentId, sfDepId, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (Objects.isNull(obj)) {
      return false;
    }
    if (obj instanceof DepartmentModel) {
      DepartmentModel other = (DepartmentModel) obj;
      if (Objects.equals(this.getParentId(), other.getParentId())
          && Objects.equals(other.getSfDepId(), this.getSfDepId())
          && Objects.equals(this.getName(), other.getName())) {
        return true;
      }
    }
    return false;
  }
}

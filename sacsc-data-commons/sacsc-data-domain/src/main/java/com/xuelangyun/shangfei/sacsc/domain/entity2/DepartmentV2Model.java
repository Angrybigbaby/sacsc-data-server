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
@Table(name = "tb_department_v2")
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentV2Model {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "parent_sf_dep_id")
  private String parentSfDepId;

  @Column(name = "sf_dep_id")
  private String sfDepId;

  @Column(name = "path_name")
  private String pathName;

  @Column(name = "path_sf_id")
  private String pathSfId;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "last_modified_time")
  private Date modifiedTime;

  @Override
  public int hashCode() {
    return Objects.hash(parentSfDepId, sfDepId, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (Objects.isNull(obj)) {
      return false;
    }
    if (obj instanceof DepartmentV2Model) {
      DepartmentV2Model other = (DepartmentV2Model) obj;
      return Objects.equals(this.getPathSfId(), other.getPathSfId())
          && Objects.equals(this.getPathName(), other.getPathName())
          && Objects.equals(other.getSfDepId(), this.getSfDepId())
          && Objects.equals(this.getName(), other.getName());
    }
    return false;
  }
}

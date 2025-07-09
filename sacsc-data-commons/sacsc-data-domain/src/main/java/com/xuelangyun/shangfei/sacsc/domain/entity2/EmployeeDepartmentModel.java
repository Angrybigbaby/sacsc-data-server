package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zijian.qjd
 */
@Builder
@Data
@Table(name = "tb_employee_department")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartmentModel {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "employee_id")
  private Long employeeId;

  @Column(name = "department_id")
  private Long departmentId;
}

package com.xuelangyun.shangfei.sacsc.datasource.mapper2;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity2.EmployeeModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zijian.qjd
 */
public interface LxEmployeeMapper extends BaseMapper<EmployeeModel> {

  @Select(
      " select "
          + " t.id as id, "
          + " t.name as name, "
          + " t.mobile as mobile, "
          + " t.card_no as cardNo, "
          + " t.sf_user_id as sfUserId, "
          + " t.userUniId as userUniId, "
          + " t.directly_sf_dep_id as directlyDepId, "
          + " t.level1_sf_dep_id as level1SfDepId, "
          + " t.subsidiary_sf_id as subsidiarySfId, "
          + " t.create_time as createTime, "
          + " t.last_modified_time as modifiedTime "
          + " from tb_employee t "
          + " left join tb_employee_department t1 on t1.employee_id = t.id "
          + " left join tb_department t2 on t2.id = t1.department_id "
          + " where t2.sf_dep_id = #{sfDeptId}")
  List<EmployeeModel> selectEmployeeBySfDeptId(@Param("sfDeptId") Integer sfDeptId);
}

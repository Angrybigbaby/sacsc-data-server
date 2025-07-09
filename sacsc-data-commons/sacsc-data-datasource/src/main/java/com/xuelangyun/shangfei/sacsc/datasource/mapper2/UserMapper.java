package com.xuelangyun.shangfei.sacsc.datasource.mapper2;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity2.RolePermission;
import com.xuelangyun.shangfei.sacsc.domain.entity2.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * @author zijian.qjd
 * @since 2021/12/20 14:11
 */
public interface UserMapper extends BaseMapper<User> {

  /**
   * 根据权限类型和工号获取用户对应权限
   *
   * @param userNumber - 工号
   * @param type - PermissionType#getType
   * @return -
   */
  @Select(
      "select rp.role_id as roleId, rp.type as type , rp.permission_id as permissionId from tb_user u "
          + " left join tb_user_role ur on u.id = ur.user_id "
          + " left join tb_role_permission rp on ur.role_id = rp.role_id "
          + " where u.user_number = #{userNumber} and rp.type = #{type} ")
  List<RolePermission> selectUserPermission(
      @Param("userNumber") String userNumber, @Param("type") Integer type);

  /**
   * 获取拥有 推送指定消息类别权限 的用户手机号列表
   *
   * @param permissionType - PermissionType#getType
   * @param msgType - MsgType#getType
   * @return -
   */
  @Select(
      "select u.user_tel from tb_user u "
          + " left join tb_user_role ur on u.id = ur.user_id "
          + " left join tb_role_permission rp on ur.role_id = rp.role_id "
          + " left join tb_permission_msg pm on rp.permission_id = pm.id "
          + " where rp.type = #{permissionT ype} and pm.type = #{msgType} ")
  Set<String> selectUserTelsWithAssignMsgPermission(
      @Param("permissionType") Integer permissionType, @Param("msgType") Integer msgType);

  /**
   * 根据权限类型和手机号获取用户对应权限
   *
   * @param userTel - 手机号
   * @param type - PermissionType#getType
   * @return -
   */
  @Select(
      "select rp.role_id as roleId, rp.type as type , rp.permission_id as permissionId from tb_user u "
          + " left join tb_user_role ur on u.id = ur.user_id "
          + " left join tb_role_permission rp on ur.role_id = rp.role_id "
          + " where u.user_tel = #{userNumber} and rp.type = #{type} ")
  List<RolePermission> selectUserPermissionWithTel(
      @Param("userTel") String userTel, @Param("type") Integer type);
}

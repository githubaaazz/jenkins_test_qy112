package com.aaa.ssm.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:RoleDao
 * description:
 * author:zz
 * createTime:2019/11/23 16:55
 * version:1.0.0
 */
public interface RoleDao {

    /**
     * 根据用户ID获取角色列表
     * @param userId
     * @return
     */
    @Select("select * from tb_role where role_id in(\n" +
            "   select role_id from tb_user_role where user_id=#{userId} \n" +
            ") ")
    List<Map> getListByUserId(int userId);

}
